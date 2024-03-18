package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.config.PayStackConfig;
import com.example.palaceecommerceapp.dtos.requests.PaymentRequest;
import com.example.palaceecommerceapp.dtos.responses.PaymentResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@Slf4j
@AllArgsConstructor

public class PalacePaymentSystem implements PayStackService{
    private final PayStackConfig payStackConfig;

    @Override
    public PaymentResponse InitialisePayment(PaymentRequest paymentRequest) {
        String URL = payStackConfig.getPayInitialise_url();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", APPLICATION_JSON_VALUE);
        httpHeaders.set("accept", APPLICATION_JSON_VALUE);
        httpHeaders.set("Authorization", payStackConfig.getAuthorization_key());
        HttpEntity<PaymentRequest> requestHttpEntity = new RequestEntity<>(
               paymentRequest,httpHeaders,POST, URI.create("")
        );
        ResponseEntity<PaymentResponse> responseEntity =
                restTemplate.postForEntity(URL,requestHttpEntity,PaymentResponse.class);
        log.info("PAYMENT ---> {}",responseEntity.getBody());

        return responseEntity.getBody();
    }
    private PaymentResponse getResponse(PaymentResponse paymentResponse){
return null;
    }
}
