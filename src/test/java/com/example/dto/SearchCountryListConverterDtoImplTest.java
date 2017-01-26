package com.example.dto;

import com.example.domain.Country;
import com.example.exception.CountryNotExistException;
import com.example.exception.NotValidDataException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class SearchCountryListConverterDtoImplTest {

    private SearchCountryListConverterDtoImpl searchConverterDto;

    @Before
    public void before(){
        this.searchConverterDto = new SearchCountryListConverterDtoImpl();
    }

    @Test
    public void convertList(){
        List<Country> countryList = createCountryList();
        List<SearchCountryDto> searchCountryDtoList = searchConverterDto.convert(countryList);
        assertTrue(searchCountryDtoList.size() == countryList.size());
    }

    @Test
    public void convertExeption(){
        CountryNotExistException notExistException = new CountryNotExistException();
        List<SearchCountryDto> searchCountryDtoList = searchConverterDto.convert(notExistException);
        assertTrue(searchCountryDtoList.size() == 1);
        assertEquals(searchCountryDtoList.get(0).getError(), "Country with such phone not exist");
        assertNotNull(searchCountryDtoList.get(0).getError());
    }

    @Test
    public void convertExeptionTwo(){
        NotValidDataException notValidDataException = new NotValidDataException();
        List<SearchCountryDto> searchCountryDtoList = searchConverterDto.convert(notValidDataException);
        assertTrue(searchCountryDtoList.size() == 1);
        assertEquals(searchCountryDtoList.get(0).getError(), "Entered data is not valid");
        assertNotNull(searchCountryDtoList.get(0).getError());
    }

    private List<Country> createCountryList(){
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
