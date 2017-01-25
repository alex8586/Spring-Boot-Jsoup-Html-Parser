package com.example;

import com.example.service.PhoneValidationService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class PhoneValidationServiceTest {

    private PhoneValidationService phoneValidationService;

    @Before
    public void before() {
        this.phoneValidationService = new PhoneValidationService();
    }

    @Test
    public void validationIfNumberIsNull() {
        boolean result  = phoneValidationService.isValidPhone(null);
        assertFalse(result);
    }

    @Test
    public void validationIfInNumberWhitespacesAndEmptyString(){
        String phone = "     ";
        boolean result = phoneValidationService.isValidPhone(phone);
        assertFalse(result);

        String phone2 = "";
        boolean result2 = phoneValidationService.isValidPhone(phone2);
        assertFalse(result2);
    }

    @Test
    public void validationIfCharactersInNumber(){
        String phone = "+371abc";
        boolean result = phoneValidationService.isValidPhone(phone);
        assertFalse(result);

        String phone2 = "+a7a7a7a";
        boolean result2 = phoneValidationService.isValidPhone(phone2);
        assertFalse(result2);

        String phone3 = "yao+372";
        boolean result3 = phoneValidationService.isValidPhone(phone3);
        assertFalse(result3);
    }

    @Test
    public void validationIfNumberLenghtIsOne(){
        String phone = "9";
        boolean result = phoneValidationService.isValidPhone(phone);
        assertFalse(result);
    }

    @Test
    public void validationIfNoPlusInNumber(){
        String phone = "97654332";
        boolean result = phoneValidationService.isValidPhone(phone);
        assertFalse(result);
    }

    @Test
    public void validationIfPlusInsideNumber(){
        String phone = "953348+5334";
        boolean result = phoneValidationService.isValidPhone(phone);
        assertFalse(result);
    }

    @Test
    public void validationIfMoreThanOnePlusInNumber(){
        String phone = "+953348+5334";
        boolean result = phoneValidationService.isValidPhone(phone);
        assertFalse(result);
    }

    @Test
    public void validationIfNumberIsRight(){
        String phone = "+9533485334";
        boolean result = phoneValidationService.isValidPhone(phone);
        assertTrue(result);

        String phone2 = "+345";
        boolean result2 = phoneValidationService.isValidPhone(phone2);
        assertTrue(result2);

        String phone3 = "+1";
        boolean result3 = phoneValidationService.isValidPhone(phone3);
        assertTrue(result3);
    }
}
