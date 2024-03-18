package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.dtos.requests.PaymentRequest;

import com.example.palaceecommerceapp.dtos.responses.PaymentResponse;

public interface PayStackService {
    PaymentResponse InitialisePayment(PaymentRequest paymentRequest);
}
