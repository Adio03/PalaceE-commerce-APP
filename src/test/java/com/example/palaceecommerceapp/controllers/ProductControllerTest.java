package com.example.palaceecommerceapp.controllers;

import com.example.palaceecommerceapp.data.models.PriceCurrency;
import com.example.palaceecommerceapp.dtos.requests.PriceRequest;
import com.example.palaceecommerceapp.dtos.requests.ProductRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static com.example.palaceecommerceapp.data.models.Categories.CLOTHES;
import static com.example.palaceecommerceapp.data.models.PriceCurrency.NGN;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc

public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ProductRequest productRequest;
    private PriceRequest priceRequest;
    private ObjectMapper objectMapper;
    @BeforeEach
    void startWith(){
        objectMapper = new ObjectMapper();
        productRequest = new ProductRequest();
        priceRequest = new PriceRequest();

        priceRequest.setGlobalPrice(new BigDecimal("200.00"));
        priceRequest.setSalePrice(new BigDecimal("100.00"));
        priceRequest.setPriceCurrency(NGN);

        productRequest.setProductName("Senator");
        productRequest.setCategories(CLOTHES);
        productRequest.setDescription("Lannal Material");
        productRequest.setPriceRequest(priceRequest);
        productRequest.setQuantity(10);
        productRequest.setMerchantId(1L);
        productRequest.setStoreId(1L);

    }
    @Test
    public void createProductTest(){
        try{
            mockMvc.perform(post("/api/v1/product/addProduct")
                    .content(objectMapper.writeValueAsBytes(productRequest))
                    .contentType(APPLICATION_JSON))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    @Test
    public void getAllProduct(){
        int page=1;
        int size=3;
        try{
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/{page}/{size}",page,size))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

}
