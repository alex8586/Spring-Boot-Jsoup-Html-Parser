package com.example.dto;

import com.example.domain.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchCountryListConverterDtoImpl implements SearchCountryListConverterDto {

    @Override
    public List<SearchCountryDto> convert(List<Country> countryList) {
        List<SearchCountryDto> dtoList = new ArrayList<>();
        for(Country country : countryList){
            SearchCountryDto countryDto = new SearchCountryDto();
            countryDto.setCountryName(country.getName());
            dtoList.add(countryDto);
        }
        return dtoList;
    }

    @Override
    public List<SearchCountryDto> convert(Exception e) {
        List<SearchCountryDto> dtoList = new ArrayList<>();
        SearchCountryDto searchCountryDto = new SearchCountryDto();
        searchCountryDto.setError(e.getMessage());
        dtoList.add(searchCountryDto);
        return dtoList;
    }
}
