package com.example.palaceecommerceapp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class TransactionRequest {
    private String senderWalletEmailAddress;
    private String receiverWalletEmailAddress;
    private BigDecimal bigDecimal;
}
