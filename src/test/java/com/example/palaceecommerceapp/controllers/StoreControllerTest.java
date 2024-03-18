package com.example.palaceecommerceapp.controllers;

import com.example.palaceecommerceapp.dtos.requests.StoreRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class StoreControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private StoreRequest storeRequest;
    private ObjectMapper objectMapper;
    @BeforeEach
    void startWith(){
        storeRequest = new StoreRequest();
        objectMapper = new ObjectMapper();
        storeRequest.setStoreName("Sully Venture");
        storeRequest.setStoreUrl("www.sully.com");
        storeRequest.setStoreDescription("technology company");
        storeRequest.setMerchantId(2L);
    }
    @Test
    public void createStoreTest(){
        try{
            mockMvc.perform(post("/api/v1/store/createStore")
                    .content(objectMapper.writeValueAsBytes(storeRequest))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    @Test
    public void getStoreByNameTest(){
        String storeName = "Sully venture";
        try{
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/store")
                            .param("storeName",storeName))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    @Test
    public void getStoreByIdTest(){
        Long storeId = 2L;
        try{
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/store/{storeId}",storeId))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

}
