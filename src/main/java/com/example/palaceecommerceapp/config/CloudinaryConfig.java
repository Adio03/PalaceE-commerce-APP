package com.example.palaceecommerceapp.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Value("${cloud.api.key}")
    private String apiKey;
    @Value("${cloud.api.secret}")
    private String apiSecret;
    @Value("${cloud.api.name}")
    private String cloudName;


    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret,
                "secure", "true",
                "folder", "palace_ecommerce"
        ));
    }



}
