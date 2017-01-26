package com.example.database;

import com.example.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DataInMemoryImpl implements DataInMemory {

    private Map<String, List<Country>> data;

    @Autowired
    public DataInMemoryImpl(DataLoader dataLoader) {
        try {
            this.data = dataLoader.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Country> getCountryByPhone(String phoneNumber) {
        List<Country> result = new ArrayList<>();

        int i = phoneNumber.length();
        boolean exit = false;
        while (!exit) {
            for (Map.Entry<String, List<Country>> entry : data.entrySet()) {
                if (entry.getKey().equals(phoneNumber)) {
                    result = entry.getValue();
                    exit = true;
                    break;
                }
            }
            if (i == 1)
                exit = true;
            phoneNumber = phoneNumber.substring(0, i--);
        }
        return result;
    }
}
