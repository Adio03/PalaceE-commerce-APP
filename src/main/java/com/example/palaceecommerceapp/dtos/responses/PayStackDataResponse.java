package com.example.palaceecommerceapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PayStackDataResponse {
    private String authorization_url;
    private String access_code;
    private String reference;
}
