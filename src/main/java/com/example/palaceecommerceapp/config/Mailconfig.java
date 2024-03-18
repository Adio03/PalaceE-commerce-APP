package com.example.palaceecommerceapp.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class Mailconfig {
    @Value("${mail.api.key}")
    private String brevoApiKey;
    @Value("${brevo.mail.url}")
    private String brevoUrl;
}
