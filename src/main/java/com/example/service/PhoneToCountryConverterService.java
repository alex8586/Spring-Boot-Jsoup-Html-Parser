package com.example.service;

import com.example.domain.Country;
import com.example.exception.CountryNotExistException;
import com.example.exception.NotValidDataException;

import java.util.List;

public interface PhoneToCountryConverterService {

    List<Country> getListCountries(String phone) throws NotValidDataException, CountryNotExistException;
}
