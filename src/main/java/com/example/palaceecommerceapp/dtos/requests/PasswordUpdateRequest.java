package com.example.palaceecommerceapp.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PasswordUpdateRequest {
    @NotNull(message = "kindly provide your current password")
    @NotBlank(message = "kindly provide your current password" )
    @NotEmpty(message = "kindly provide your current password")
    private String currentPassword;
    @NotNull(message = "kindly provide your new password")
    @NotBlank(message = "kindly provide your new password" )
    @NotEmpty(message = "kindly provide your new password")
    private String newPassword;
    private Long merchantId;

}
