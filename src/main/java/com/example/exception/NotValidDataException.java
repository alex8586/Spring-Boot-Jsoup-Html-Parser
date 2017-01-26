package com.example.exception;

public class NotValidDataException extends Exception {

    private final static String NOT_VALID_DATA = "Entered data is not valid";

    public NotValidDataException() {
        super(NOT_VALID_DATA);
    }
}
