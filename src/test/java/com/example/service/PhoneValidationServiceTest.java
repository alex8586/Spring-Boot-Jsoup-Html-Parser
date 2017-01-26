package com.example.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhoneValidationServiceTest {
//
//    private PhoneValidationService phoneValidationService;
//
//    @Before
//    public void before() {
//        this.phoneValidationService = new PhoneValidationService();
//    }
//
//    @Test
//    public void validationIfNumberIsNull() {
//        boolean result  = phoneValidationService.validatePhoneNumber(null);
//        assertFalse(result);
//    }
//
//    @Test
//    public void validationIfInNumberWhitespacesAndEmptyString(){
//        String phone = "     ";
//        boolean result = phoneValidationService.validatePhoneNumber(phone);
//        assertFalse(result);
//
//        String phone2 = "";
//        boolean result2 = phoneValidationService.validatePhoneNumber(phone2);
//        assertFalse(result2);
//    }
//
//    @Test
//    public void validationIfCharactersInNumber(){
//        String phone = "+371abc";
//        boolean result = phoneValidationService.validatePhoneNumber(phone);
//        assertFalse(result);
//
//        String phone2 = "+a7a7a7a";
//        boolean result2 = phoneValidationService.validatePhoneNumber(phone2);
//        assertFalse(result2);
//
//        String phone3 = "yao+372";
//        boolean result3 = phoneValidationService.validatePhoneNumber(phone3);
//        assertFalse(result3);
//    }
//
//    @Test
//    public void validationIfNumberLenghtIsOne(){
//        String phone = "9";
//        boolean result = phoneValidationService.validatePhoneNumber(phone);
//        assertFalse(result);
//    }
//
//    @Test
//    public void validationIfNoPlusInNumber(){
//        String phone = "97654332";
//        boolean result = phoneValidationService.validatePhoneNumber(phone);
//        assertFalse(result);
//    }
//
//    @Test
//    public void validationIfPlusInsideNumber(){
//        String phone = "953348+5334";
//        boolean result = phoneValidationService.validatePhoneNumber(phone);
//        assertFalse(result);
//    }
//
//    @Test
//    public void validationIfMoreThanOnePlusInNumber(){
//        String phone = "+953348+5334";
//        boolean result = phoneValidationService.validatePhoneNumber(phone);
//        assertFalse(result);
//    }
//
//    @Test
//    public void validationIfNumberIsRight(){
//        String phone = "+9533485334";
//        boolean result = phoneValidationService.validatePhoneNumber(phone);
//        assertTrue(result);
//
//        String phone2 = "+345";
//        boolean result2 = phoneValidationService.validatePhoneNumber(phone2);
//        assertTrue(result2);
//
//        String phone3 = "+1";
//        boolean result3 = phoneValidationService.validatePhoneNumber(phone3);
//        assertTrue(result3);
//    }
}
