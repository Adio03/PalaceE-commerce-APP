package com.example.palaceecommerceapp.config;

import jakarta.persistence.Column;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modalMapper(){
        return new ModelMapper();
    }
}
