package com.example.palaceecommerceapp.controllers;

import com.example.palaceecommerceapp.dtos.requests.LoginRequest;
import com.example.palaceecommerceapp.dtos.requests.MerchantRequest;
import com.example.palaceecommerceapp.dtos.requests.PasswordUpdateRequest;
import com.example.palaceecommerceapp.dtos.responses.LoginResponse;
import com.example.palaceecommerceapp.dtos.responses.MerchantResponse;
import com.example.palaceecommerceapp.dtos.responses.PasswordUpdateResponse;
import com.example.palaceecommerceapp.exceptions.MerchantFoundException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.services.MerchantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
@AllArgsConstructor
public class MerchantController {
    private MerchantService merchantService;

    @PostMapping("/registerMerchant")
    public ResponseEntity<?> registerMerchant(@RequestBody @Valid MerchantRequest merchantRequest) throws MerchantFoundException {
        MerchantResponse merchantResponse = merchantService.registerMerchant(merchantRequest);
        return new ResponseEntity<>(merchantResponse, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) throws MerchantNotFoundException {
        LoginResponse loginResponse = merchantService.login(loginRequest);
        return new ResponseEntity<>(loginResponse,HttpStatus.OK);
    }
    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody @Valid PasswordUpdateRequest passwordUpdateRequest) throws MerchantNotFoundException {
        PasswordUpdateResponse passwordUpdateResponse = merchantService.changePassword(passwordUpdateRequest);
        return new ResponseEntity<>(passwordUpdateResponse,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getMerchantWithId(@PathVariable Long id) throws MerchantNotFoundException {
        return ResponseEntity.ok(merchantService.getMerchantById(id));

    }
}
