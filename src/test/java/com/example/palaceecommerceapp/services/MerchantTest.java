package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.dtos.requests.LoginRequest;
import com.example.palaceecommerceapp.dtos.requests.MerchantRequest;
import com.example.palaceecommerceapp.dtos.requests.PasswordUpdateRequest;
import com.example.palaceecommerceapp.dtos.responses.LoginResponse;
import com.example.palaceecommerceapp.dtos.responses.MerchantResponse;
import com.example.palaceecommerceapp.dtos.responses.PasswordUpdateResponse;
import com.example.palaceecommerceapp.exceptions.MerchantFoundException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MerchantTest {
    @Autowired
    public MerchantService merchantService;
    private MerchantRequest merchantRequest;
    private LoginRequest loginRequest;
    private PasswordUpdateRequest passwordUpdateRequest;

    @BeforeEach
    void setUp (){
        merchantRequest = new MerchantRequest();
        merchantRequest.setFirstName("John");
        merchantRequest.setLastName("Ebuka");
        merchantRequest.setEmail("john@gmail.com");
        merchantRequest.setPhoneNumber("07011223344");
        merchantRequest.setUserName("Jonny");
        merchantRequest.setPassword("12345678");

        loginRequest = new LoginRequest();
        loginRequest.setEmail("john@gmail.com");
        loginRequest.setPassword("12345678");

        passwordUpdateRequest = new PasswordUpdateRequest();
        passwordUpdateRequest.setCurrentPassword("12345678");
        passwordUpdateRequest.setNewPassword("JonnyCage@@");
        passwordUpdateRequest.setMerchantId(1L);

    }
    @Test
    public void merchantRegistrationTest() throws MerchantFoundException {
        MerchantResponse merchantResponse = merchantService.registerMerchant(merchantRequest);
        assertNotNull(merchantResponse);
        assertNotNull(merchantResponse.getMerchantId());
        assertNotNull(merchantResponse.getMessage());
    }
    @Test
    public void merchantLoginTest() throws MerchantNotFoundException {
        LoginResponse loginResponse = merchantService.login(loginRequest);
        assertNotNull(loginResponse);
        assertNotNull(loginResponse.getMessage());

    }
    @Test
    public void passwordUpdateTest() throws MerchantNotFoundException {
        PasswordUpdateResponse passwordUpdateResponse = merchantService.changePassword(passwordUpdateRequest);
        assertNotNull(passwordUpdateResponse);
        assertNotNull(passwordUpdateResponse.getMessage());

    }
    @Test
    public void throwExceptionWhenFindMerchantWithUnRegisteredEmailTest() throws MerchantNotFoundException {
        String email = "benny@gmail.com";
        assertThrows(MerchantNotFoundException.class,()-> merchantService.getMerchantByEmail(email));
    }
    @Test
    public void throwExceptionWhenFindMerchantWithIdThatDoesNotExistTest(){
        Long id = 34L;
        assertThrows(MerchantNotFoundException.class,()->merchantService.getMerchantById(id));
    }
    @Test
    public void getMerchantByIdTest() throws MerchantNotFoundException {
        Long id = 1L;
        assertNotNull(merchantService.getMerchantById(id));
    }
    @Test
    public void getMerchantWithEmail() throws MerchantNotFoundException {
        String email ="benji@gmail.com";
        assertNotNull(merchantService.getMerchantByEmail(email));
    }



}
