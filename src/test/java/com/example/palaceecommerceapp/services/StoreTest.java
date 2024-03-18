package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.dtos.requests.StoreRequest;
import com.example.palaceecommerceapp.dtos.responses.StoreResponse;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.StoreAlreadyExistException;
import com.example.palaceecommerceapp.exceptions.StoreNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StoreTest {
    @Autowired
    private StoreService storeService;
    private StoreRequest storeRequest;
    @BeforeEach
     void startWith(){
        storeRequest = new StoreRequest();
        storeRequest.setStoreName("Latiss Fashion Venture");
        storeRequest.setStoreUrl("www.latissFashion.com");
        storeRequest.setStoreDescription("Fashion Designer");
        storeRequest.setMerchantId(1L);
    }
    @Test
    public void storeCreationTest() throws MerchantNotFoundException, StoreNotFoundException, StoreAlreadyExistException {
        StoreResponse storeResponse = storeService.createStore(storeRequest);
        assertNotNull(storeResponse);
        assertNotNull(storeResponse.getMessage());
    }
    @Test
    public void throwExceptionWhenAStoreThatDoesNotExistIsFindByStoreNameTest(){
        String storeName = "Ola venture";
        assertThrows(StoreNotFoundException.class,()-> storeService.getStoreByStoreName(storeName));
    }
    @Test
    public void throwExceptionWhenAStoreThatDoesNotExistIsFindByIdTest(){
        Long storeId = 500L;
        assertThrows(StoreNotFoundException.class,()-> storeService.getStoreById(storeId));
    }
}


