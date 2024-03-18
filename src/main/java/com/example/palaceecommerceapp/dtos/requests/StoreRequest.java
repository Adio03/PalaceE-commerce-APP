package com.example.palaceecommerceapp.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class StoreRequest {
    @NotNull(message = "kindly provide your store name")
    @NotEmpty(message = "kindly provide your store name")
    @NotBlank(message = "kindly provide your store name")
    private String storeName;
    @NotNull(message = "kindly provide your store url")
    @NotEmpty(message = "kindly provide your store url")
    @NotBlank(message = "kindly provide your store url")
    private String storeUrl;
    @NotNull(message = "kindly provide your store description")
    @NotEmpty(message = "kindly provide your store description")
    @NotBlank(message = "kindly provide your store description")
    private String storeDescription;
    private Long merchantId;


}
