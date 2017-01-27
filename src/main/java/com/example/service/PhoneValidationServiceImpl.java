package com.example.service;

import com.example.exception.NotValidDataException;
import org.springframework.stereotype.Service;

@Service
public class PhoneValidationServiceImpl implements PhoneValidationService{

    public void validatePhoneNumber(String phone) throws NotValidDataException {
        if(phone == null){
            throw new NotValidDataException();
        }
        phone = phone.replaceAll(" ", "");
        if(phone.length() < 2 || !phone.matches("[/?+][0-9]+")){
            throw new NotValidDataException();
        }
    }
}
