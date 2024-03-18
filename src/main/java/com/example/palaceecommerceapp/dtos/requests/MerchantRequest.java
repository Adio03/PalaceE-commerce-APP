package com.example.palaceecommerceapp.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MerchantRequest {
@NotNull(message = "kindly provide your name")
    private String firstName;
@NotNull(message = "kindly provide your name")
    private String lastName;
@NotNull(message = "kindly provide your email")
@Email
    private String email;
@NotNull(message = "kindly provide your phone number")
    private String phoneNumber;
@NotNull(message = "kindly provide your userName")
    private String userName;
@NotNull(message = "kindly provide your password")
    private String password;



}
