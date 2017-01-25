package com.example.rest;

import com.example.domain.Country;
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

    @RequestMapping(value = "/api/{phone}", method = RequestMethod.GET)
    public List<Country> getCountry(@PathVariable("phone") String phone) {
        return phoneToCountryConverterService.getCountryByPhone(phone);
    }
}
