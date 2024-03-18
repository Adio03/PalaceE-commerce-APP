package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.data.models.Store;
import com.example.palaceecommerceapp.dtos.requests.StoreRequest;
import com.example.palaceecommerceapp.dtos.responses.StoreResponse;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.StoreAlreadyExistException;
import com.example.palaceecommerceapp.exceptions.StoreNotFoundException;

public interface StoreService {
    StoreResponse createStore(StoreRequest storeRequest) throws MerchantNotFoundException, StoreNotFoundException, StoreAlreadyExistException;
    Store getStoreById(Long id) throws StoreNotFoundException;
    Store getStoreByStoreName(String storeName) throws StoreNotFoundException;
}
