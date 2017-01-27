package com.example.service;

import com.example.exception.NotValidDataException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhoneValidationServiceImplTest {

    private PhoneValidationService phoneValidationService;

    @Before
    public void before() {
        this.phoneValidationService = new PhoneValidationServiceImpl();
    }

    @Test(expected = NotValidDataException.class)
    public void validationIfNumberIsNull() throws NotValidDataException {
        phoneValidationService.validatePhoneNumber(null);
    }

    @Test(expected = NotValidDataException.class)
    public void validationIfInNumberWhitespaces() throws NotValidDataException {
        String phone = "     ";
        phoneValidationService.validatePhoneNumber(phone);
    }

    @Test(expected = NotValidDataException.class)
    public void validationIfInNumberEmptyString() throws NotValidDataException {
        String phone = "";
        phoneValidationService.validatePhoneNumber(phone);
    }

    @Test(expected = NotValidDataException.class)
    public void validationIfCharactersInNumber() throws NotValidDataException {
        String phone = "+371abc";
        phoneValidationService.validatePhoneNumber(phone);
    }

    @Test(expected = NotValidDataException.class)
    public void validationIfCharactersInNumber2() throws NotValidDataException {
        String phone = "+a7a7a7a";
        phoneValidationService.validatePhoneNumber(phone);
    }

    @Test(expected = NotValidDataException.class)
    public void validationIfCharactersInNumber3() throws NotValidDataException {
        String phone = "yao+372";
        phoneValidationService.validatePhoneNumber(phone);
    }

    @Test(expected = NotValidDataException.class)
    public void validationIfNumberLenghtIsOne() throws NotValidDataException {
        String phone = "9";
        phoneValidationService.validatePhoneNumber(phone);
    }

    @Test(expected = NotValidDataException.class)
    public void validationIfNoPlusInNumber() throws NotValidDataException {
        String phone = "97654332";
        phoneValidationService.validatePhoneNumber(phone);
    }

    @Test(expected = NotValidDataException.class)
    public void validationIfPlusInsideNumber() throws NotValidDataException {
        String phone = "953348+5334";
        phoneValidationService.validatePhoneNumber(phone);
    }

    @Test(expected = NotValidDataException.class)
    public void validationIfMoreThanOnePlusInNumber() throws NotValidDataException {
        String phone = "+953348+5334";
        phoneValidationService.validatePhoneNumber(phone);
    }

    @Test
    public void validationIfNumberIsRight() throws NotValidDataException {
        String phone = "+9533485334";
        phoneValidationService.validatePhoneNumber(phone);
    }

}
