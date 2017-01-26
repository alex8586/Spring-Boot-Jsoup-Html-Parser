package com.example.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhoneToCountryConverterServiceTest {
//
//    @Mock
//    private FillingDataService fillingDataService;
//
//    @Mock
//    private PhoneValidationService phoneValidationService;
//
//    @InjectMocks
//    private PhoneToCountryConverterService phoneToCountryConverterService;
//
//    private final static String NOT_VALID_DATA = "Entered data is not valid";
//    private final static String COUNTRY_NOT_EXIST = "Country with such phone not exist";
//
//    @Before
//    public void before() {
//        this.phoneToCountryConverterService = new PhoneToCountryConverterService();
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void shouldReturnErrorIfNumberNotValid(){
//        when(phoneValidationService.validatePhoneNumber(anyString())).thenReturn(false);
//        List<Country> result = phoneToCountryConverterService.getCountryByPhone(anyString());
//        assertTrue(result.size() == 1);
//        assertEquals(result.get(0).getName(), NOT_VALID_DATA);
//    }
//
//    @Test
//    public void shouldReturnErrorIfNumberNotExist(){
//        Map<String, List<Country>> testDataMap = getTestData();
//        when(phoneValidationService.validatePhoneNumber(anyString())).thenReturn(true);
//        when(fillingDataService.getCountryList()).thenReturn(testDataMap);
//
//        List<Country> result = phoneToCountryConverterService.getCountryByPhone("+234567891");
//        assertTrue(result.size() == 1);
//        assertEquals(result.get(0).getName(), COUNTRY_NOT_EXIST);
//    }
//
//    @Test
//    public void shouldReturnCountryListRightSize(){
//        Map<String, List<Country>> testDataMap = getTestData();
//        when(phoneValidationService.validatePhoneNumber(anyString())).thenReturn(true);
//        when(fillingDataService.getCountryList()).thenReturn(testDataMap);
//
//        List<Country> result = phoneToCountryConverterService.getCountryByPhone("+590 2674");
//        assertTrue(result.size() == 3);
//
//        List<Country> result2 = phoneToCountryConverterService.getCountryByPhone("+221 36452");
//        assertTrue(result2.size() == 1);
//
//        List<Country> result3 = phoneToCountryConverterService.getCountryByPhone("+500 84736");
//        assertTrue(result3.size() == 2);
//
//        verify(fillingDataService, times(3)).getCountryList();
//    }
//
//    private Map<String, List<Country>> getTestData(){
//        Map<String, List<Country>> testdataMap = new HashMap<>();
//
//        List<Country> countryList = new ArrayList<>();
//        Country country = new Country();
//        country.setName("Senegal");
//        countryList.add(country);
//        testdataMap.put("+221", countryList);
//
//        List<Country> countryList2 = new ArrayList<>();
//        Country country2 = new Country();
//        country2.setName("Falkland Islands");
//        countryList2.add(country2);
//        Country country3 = new Country();
//        country3.setName("South Georgia and the South Sandwich Islands");
//        countryList2.add(country3);
//        testdataMap.put("+500", countryList2);
//
//        List<Country> countryList3 = new ArrayList<>();
//        Country country4 = new Country();
//        country4.setName("Guadeloupe");
//        countryList3.add(country4);
//
//        Country country5 = new Country();
//        country5.setName("Saint Barthélemy");
//        countryList3.add(country5);
//
//        Country country6 = new Country();
//        country6.setName("Saint Martin (France)");
//        countryList3.add(country6);
//        testdataMap.put("+590", countryList3);
//
//        return testdataMap;
//    }
}
