package com.example.palaceecommerceapp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private String email;
    private String amount;

}
