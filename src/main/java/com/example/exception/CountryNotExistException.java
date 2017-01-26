package com.example.exception;

public class CountryNotExistException extends Exception {

    private final static String COUNTRY_NOT_EXIST = "Country with such phone not exist";

    public CountryNotExistException() {
        super(COUNTRY_NOT_EXIST);
    }
}
