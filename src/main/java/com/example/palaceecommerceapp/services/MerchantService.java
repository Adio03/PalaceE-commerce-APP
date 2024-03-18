package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.data.models.Merchant;
import com.example.palaceecommerceapp.dtos.requests.LoginRequest;
import com.example.palaceecommerceapp.dtos.requests.MerchantRequest;
import com.example.palaceecommerceapp.dtos.requests.PasswordUpdateRequest;
import com.example.palaceecommerceapp.dtos.responses.LoginResponse;
import com.example.palaceecommerceapp.dtos.responses.MerchantResponse;
import com.example.palaceecommerceapp.dtos.responses.PasswordUpdateResponse;
import com.example.palaceecommerceapp.exceptions.MerchantFoundException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;

public interface MerchantService {
    MerchantResponse registerMerchant(MerchantRequest merchantRequest) throws MerchantFoundException;
    LoginResponse login(LoginRequest loginRequest) throws MerchantNotFoundException;
    Merchant getMerchantByEmail(String email) throws MerchantNotFoundException;
    PasswordUpdateResponse changePassword(PasswordUpdateRequest passwordUpdateRequest) throws MerchantNotFoundException;
    Merchant getMerchantById(Long id) throws MerchantNotFoundException;
}
