package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.dtos.requests.PaymentRequest;
import com.example.palaceecommerceapp.dtos.responses.PaymentResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PayStackPaymentIntegrationTest {
    @Autowired
    private PayStackService payStackService;

    @Test
    public void paymentInitialiseTest(){
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setEmail("adioldmj@gmail.com");
        paymentRequest.setAmount("10000");

        PaymentResponse paymentResponse = payStackService.InitialisePayment(paymentRequest);
        assertNotNull(paymentResponse);
        assertNotNull(paymentResponse.getMessage());
        assertNotNull(paymentResponse.getData());
    }
}
