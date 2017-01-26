package com.example.dto;

import com.example.domain.Country;

import java.util.List;

public interface SearchCountryListConverterDto {

    List<SearchCountryDto> convert(List<Country> countryList);

    List<SearchCountryDto> convert(Exception e);
}
