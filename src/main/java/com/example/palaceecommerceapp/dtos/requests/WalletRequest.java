package com.example.palaceecommerceapp.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class WalletRequest {
    @NotEmpty
    @NotBlank
    @NotNull
    private Long merchantId;
    @NotEmpty
    @NotBlank
    @NotNull
    private BigDecimal amount;
    @NotEmpty
    @NotBlank
    @NotNull
    private Long walletId;



}
