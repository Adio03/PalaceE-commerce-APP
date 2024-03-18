package com.example.palaceecommerceapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponse {
    private Long productId;
    private Long merchantId;
    private Long storeId;
   private PriceResponse productPrice;
    private String message;
}
