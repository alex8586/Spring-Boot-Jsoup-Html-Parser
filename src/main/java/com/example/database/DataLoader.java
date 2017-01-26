package com.example.database;

import com.example.domain.Country;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DataLoader {

    Map<String, List<Country>> init() throws IOException;
}
