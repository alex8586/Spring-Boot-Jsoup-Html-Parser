package com.example.database;

import com.example.domain.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataLoaderImplTest {

    @Autowired
    private DataLoader dataLoader;

    @Test
    public void loadDataTest() throws IOException {
        Map<String, List<Country>> map = dataLoader.loadData();
        assertTrue(!map.isEmpty());

        for(Map.Entry<String, List<Country>> entry : map.entrySet()){
            String phone = entry.getKey();
            String plus = phone.substring(0,1);
            assertEquals("+", plus);
            String numbers = phone.substring(1);
            Integer.parseInt(numbers);
        }
    }
}
