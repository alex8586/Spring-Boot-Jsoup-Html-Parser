package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class PhoneValidationService {

    public boolean isValidPhone(String phone){
        if(phone == null)
            return false;

        phone = phone.replaceAll(" ","");
        return phone.matches("[/?+][0-9]+") && phone.length() > 1;
    }
}
