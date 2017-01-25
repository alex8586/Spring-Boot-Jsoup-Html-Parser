package com.example;

import com.example.domain.Country;
import com.example.service.PhoneToCountryConverterService;
import com.example.service.FillingDataService;
import com.example.service.PhoneValidationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PhoneToCountryConverterServiceTest {

    @Mock
    private FillingDataService fillingDataService;

    @Mock
    private PhoneValidationService phoneValidationService;

    @InjectMocks
    private PhoneToCountryConverterService phoneToCountryConverterService;

    private final static String NOT_VALID_DATA = "Entered data is not valid";
    private final static String COUNTRY_NOT_EXIST = "Country with such phone not exist";

    @Before
    public void before() {
        this.phoneToCountryConverterService = new PhoneToCountryConverterService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnErrorIfNumberNotValid(){
        List<Country> result = new ArrayList<>();
        when(phoneValidationService.isValidPhone(anyString())).thenReturn(false);
//        Mockito.doReturn(false).when(phoneValidationService.isValidPhone(" "));
        result = phoneToCountryConverterService.getCountryByPhone(anyString());
        assertTrue(result.size() == 1);
        assertEquals(result.get(0).getName(), NOT_VALID_DATA);
    }
}
