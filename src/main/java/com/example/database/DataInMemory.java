package com.example.database;

import com.example.domain.Country;

import java.util.List;

public interface DataInMemory {

    List<Country> getCountryByPhone(String phone);
}
