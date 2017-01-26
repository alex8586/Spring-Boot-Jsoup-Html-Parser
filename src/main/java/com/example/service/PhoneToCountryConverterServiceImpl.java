package com.example.service;

import com.example.database.DataInMemory;
import com.example.domain.Country;
import com.example.exception.CountryNotExistException;
import com.example.exception.NotValidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneToCountryConverterServiceImpl implements PhoneToCountryConverterService {

    @Autowired
    private PhoneValidationService phoneValidationService;

    @Autowired
    private DataInMemory dataInMemory;

    @Value("#{ new Integer('${maxLenghtPhoneCode}')}")
    private int maxLenghtPhoneCode;

    @Override
    public List<Country> getListCountries(String phone) throws NotValidDataException, CountryNotExistException {
        phoneValidationService.validatePhoneNumber(phone);
        String phoneNumber = cutPhoneTillCurrentMaxLenghtPhoneCode(phone);
        List<Country> result = dataInMemory.getCountryByPhone(phoneNumber);
        if (result.isEmpty()) {
            throw new CountryNotExistException();
        }
        return result;
    }

    private String cutPhoneTillCurrentMaxLenghtPhoneCode(String phone){
        String result = phone.replaceAll(" ", "");
        if (result.length() > maxLenghtPhoneCode) {
            result = result.substring(0, maxLenghtPhoneCode);
        }
        return result;
    }
}
