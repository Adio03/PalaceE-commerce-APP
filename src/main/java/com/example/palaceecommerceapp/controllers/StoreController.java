package com.example.palaceecommerceapp.controllers;

import com.example.palaceecommerceapp.dtos.requests.StoreRequest;
import com.example.palaceecommerceapp.dtos.responses.StoreResponse;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.StoreAlreadyExistException;
import com.example.palaceecommerceapp.exceptions.StoreNotFoundException;
import com.example.palaceecommerceapp.services.StoreService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
@AllArgsConstructor
public class StoreController {
    private StoreService storeService;

    @PostMapping("/createStore")
    public ResponseEntity<?> creatStore(@RequestBody @Valid StoreRequest storeRequest) throws MerchantNotFoundException, StoreNotFoundException, StoreAlreadyExistException {
        StoreResponse storeResponse = storeService.createStore(storeRequest);
        return new ResponseEntity<>(storeResponse, HttpStatus.OK);
    }
    @GetMapping(params = "storeName")
    public ResponseEntity<?> getStoreByStoreName(@RequestParam String storeName) throws StoreNotFoundException {
        return ResponseEntity.ok(storeService.getStoreByStoreName(storeName));
    }
    @GetMapping("/{storeId}")
    public ResponseEntity<?> getStoreById(@PathVariable Long storeId) throws StoreNotFoundException {
        return ResponseEntity.ok(storeService.getStoreById(storeId));
    }
}
