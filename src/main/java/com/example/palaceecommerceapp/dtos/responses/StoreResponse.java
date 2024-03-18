package com.example.palaceecommerceapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StoreResponse {
    private String message;
    private Long storeId;
    private Long merchantId;
    private String storeName;
}
