package com.example.service;

import com.example.exception.NotValidDataException;

public interface PhoneValidationService {

    void validatePhoneNumber(String phone) throws NotValidDataException;
}
