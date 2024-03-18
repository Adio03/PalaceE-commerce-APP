package com.example.palaceecommerceapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class WalletResponse {
    private Long merchantId;
    private Long walletId;
    private BigDecimal balance;
    private String message;


}
