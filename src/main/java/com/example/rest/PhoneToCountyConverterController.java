package com.example.rest;

import com.example.domain.Country;
import com.example.dto.SearchCountryDto;
import com.example.dto.SearchCountryListConverterDto;
import com.example.exception.CountryNotExistException;
import com.example.exception.NotValidDataException;
import com.example.service.PhoneToCountryConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneToCountyConverterController {

    @Autowired
    private PhoneToCountryConverterService phoneToCountryConverterService;

    @Autowired
    private SearchCountryListConverterDto listConverterDto;

    @RequestMapping(value = "/api/{phone}", method = RequestMethod.GET)
    public List<SearchCountryDto> getCountry(@PathVariable("phone") String phone) {
        try {
            List<Country> countryList = phoneToCountryConverterService.getListCountries(phone);
            return listConverterDto.convert(countryList);
        } catch (NotValidDataException e) {
            return listConverterDto.convert(e);
        } catch (CountryNotExistException e) {
            return listConverterDto.convert(e);
        }
    }
}
