package com.example.palaceecommerceapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PaymentResponse {
    private boolean status;
    private String message;
    private PayStackDataResponse data;

}
