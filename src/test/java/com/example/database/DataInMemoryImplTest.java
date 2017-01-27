package com.example.database;

import com.example.domain.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInMemoryImplTest {

    @Autowired
    private DataInMemory dataInMemory;

    @Test
    public void getCountryByPhoneTest(){
        String phone = "+371";
        List<Country> countryList = dataInMemory.getCountryByPhone(phone);
        assertTrue(!countryList.isEmpty());
        assertTrue(countryList.size() == 1);
        assertEquals(countryList.get(0).getName(), "Latvia");
    }

    @Test
    public void getCountryByPhoneTest2(){
        String phone = "+55";
        List<Country> countryList = dataInMemory.getCountryByPhone(phone);
        assertTrue(!countryList.isEmpty());
        assertTrue(countryList.size() == 1);
        assertEquals(countryList.get(0).getName(), "Brazil");
    }

    @Test
    public void getCountryByPhoneTest3(){
        String phone = "+23";
        List<Country> countryList = dataInMemory.getCountryByPhone(phone);
        assertTrue(countryList.isEmpty());
        assertTrue(countryList.size() == 0);
    }

}
