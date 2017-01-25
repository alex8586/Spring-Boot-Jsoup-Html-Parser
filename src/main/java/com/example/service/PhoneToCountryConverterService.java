package com.example.service;

import com.example.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PhoneToCountryConverterService {

    private final static String NOT_VALID_DATA = "Entered data is not valid";
    private final static String COUNTRY_NOT_EXIST = "Country with such phone not exist";

    @Autowired
    private FillingDataService fillingDataService;

    @Autowired
    private PhoneValidationService phoneValidationService;

    public List<Country> getCountryByPhone(String phone) {
        List<Country> result = new ArrayList<>();
        if (!phoneValidationService.isValidPhone(phone)) {
            Country country = new Country();
            country.setName(NOT_VALID_DATA);
            result.add(country);
            return result;
        }
        String phoneNumber = phone.replaceAll(" ", "");
        if (phoneNumber.length() > 8) {
            phoneNumber = phoneNumber.substring(0, 8);
        }

        Map<String, List<Country>> map = fillingDataService.getCountryList();

        int i = phoneNumber.length();
        boolean exit = false;
        while (!exit) {
            for (Map.Entry<String, List<Country>> entry : map.entrySet()) {
                if (entry.getKey().equals(phoneNumber)) {
                    result = entry.getValue();
                    exit = true;
                    break;
                }
            }
            if (i == 1)
                exit = true;

            phoneNumber = phoneNumber.substring(0, i--);
        }
        if (result.isEmpty()) {
            Country country = new Country();
            country.setName(COUNTRY_NOT_EXIST);
            result.add(country);
        }
        return result;
    }
}
