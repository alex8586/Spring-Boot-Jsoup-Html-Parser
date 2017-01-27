package com.example.utils;

import com.example.domain.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestData {

    public List<Country> createCountryList(){
        Country country = new Country();
        country.setName("Bangladesh");
        Country country2 = new Country();
        country2.setName("Egypet");

        List<Country> result = new ArrayList<>();
        result.add(country);
        result.add(country2);
        return result;
    }
}
