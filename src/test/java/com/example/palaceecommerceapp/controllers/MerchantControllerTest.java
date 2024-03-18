package com.example.palaceecommerceapp.controllers;

import com.example.palaceecommerceapp.dtos.requests.LoginRequest;
import com.example.palaceecommerceapp.dtos.requests.MerchantRequest;
import com.example.palaceecommerceapp.dtos.requests.PasswordUpdateRequest;
import com.example.palaceecommerceapp.services.MerchantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class MerchantControllerTest {
    @Autowired
    private MockMvc mockMvc;
    public MerchantService merchantService;
    private MerchantRequest merchantRequest;
    private LoginRequest loginRequest;
    private PasswordUpdateRequest passwordUpdateRequest;
   private  ObjectMapper objectMapper ;

    @BeforeEach
    void setUp (){
        objectMapper = new ObjectMapper();

        merchantRequest = new MerchantRequest();
        merchantRequest.setFirstName("Ben");
        merchantRequest.setLastName("Benji");
        merchantRequest.setEmail("benji@gmail.com");
        merchantRequest.setPhoneNumber("07011223345");
        merchantRequest.setUserName("Benny");
        merchantRequest.setPassword("12345678");

        loginRequest = new LoginRequest();
        loginRequest.setEmail("benji@gmail.com");
        loginRequest.setPassword("12345678");

        passwordUpdateRequest = new PasswordUpdateRequest();
        passwordUpdateRequest.setCurrentPassword("12345678");
        passwordUpdateRequest.setNewPassword("JonnyCage");
        passwordUpdateRequest.setMerchantId(2L);

    }
    @Test
    public void merchantRegisterTestController() {
        try {
            mockMvc.perform(post("/api/v1/merchant/registerMerchant")
                            .content(objectMapper.writeValueAsBytes(merchantRequest))
                            .contentType(APPLICATION_JSON))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        @Test
         public void loginControllerTest(){
        try{
            mockMvc.perform(post("/api/v1/merchant/login")
                    .content(objectMapper.writeValueAsBytes(loginRequest))
                    .contentType(APPLICATION_JSON))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());
        }catch (Exception exception){
            exception.printStackTrace();
        }

        }
        @Test
        public void changePasswordTestController(){
        try{
            mockMvc.perform(post("/api/v1/merchant/changePassword")
                    .content(objectMapper.writeValueAsBytes(passwordUpdateRequest))
                    .contentType(APPLICATION_JSON))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        }
        @Test
        public void getMerchantWithIdTest(){
        Long id = 2L;
        try{
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/merchant/{id}",id))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());

        }catch (Exception exception){
            exception.printStackTrace();
        }
        }

    }


