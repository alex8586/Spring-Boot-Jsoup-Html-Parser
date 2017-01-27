package com.example.service;

import com.example.database.DataInMemory;
import com.example.domain.Country;
import com.example.exception.CountryNotExistException;
import com.example.exception.NotValidDataException;
import com.example.utils.TestData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PhoneToCountryConverterServiceImplTest {

    @Mock
    private PhoneValidationService phoneValidationService;

    @Mock
    private DataInMemory dataInMemory;

    @InjectMocks
    private PhoneToCountryConverterService phoneToCountryConverterService;

    private TestData testData;

    @Before
    public void before() {
        this.phoneToCountryConverterService = new PhoneToCountryConverterServiceImpl();
        this.testData = new TestData();
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = NotValidDataException.class)
    public void shouldThrowException() throws NotValidDataException, CountryNotExistException {
        String phone = "+1s2d";
        doThrow(NotValidDataException.class).when(phoneValidationService).validatePhoneNumber(phone);
        phoneToCountryConverterService.getListCountries(phone);
    }

    @Test(expected = CountryNotExistException.class)
    public void shouldThrowException2() throws NotValidDataException, CountryNotExistException {
        String phone = "+23";
        List<Country> countryList = new ArrayList<>();
        when(dataInMemory.getCountryByPhone(phone)).thenReturn(countryList);
        phoneToCountryConverterService.getListCountries(phone);
    }

    @Test
    public void shouldPassWhenEverythingOk() throws NotValidDataException, CountryNotExistException{
        String phone = "+654321";
        List<Country> countryList = testData.createCountryList();
        when(dataInMemory.getCountryByPhone(anyString())).thenReturn(countryList);
        List<Country> result = phoneToCountryConverterService.getListCountries(phone);
        assertTrue(result.size() == 2);
    }

}
