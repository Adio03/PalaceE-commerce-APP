package com.example.palaceecommerceapp.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    @NotNull(message = "kingly enter your email")
    @NotBlank(message = "kingly enter your email")
    @NotBlank(message = "kingly enter your email")
    private String email;
    @NotNull(message = "kingly enter your password")
    @NotBlank(message = "kingly enter your password")
    @NotBlank(message = "kingly enter your password")
    private String password;
}
