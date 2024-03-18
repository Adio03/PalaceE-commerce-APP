package com.example.palaceecommerceapp.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter

public class PayStackConfig {
    @Value("${payStack_authorization_key}")
    private String authorization_key;
    @Value("${payStack_paymentInitialise_url}")
    private String payInitialise_url;
}
