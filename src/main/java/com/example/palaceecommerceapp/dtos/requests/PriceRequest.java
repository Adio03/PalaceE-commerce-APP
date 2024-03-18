package com.example.palaceecommerceapp.dtos.requests;

import com.example.palaceecommerceapp.data.models.PriceCurrency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class PriceRequest {
    @NotNull(message = "kindly provide the product global price")
    @NotBlank(message = "kindly provide the product global price")
    @NotEmpty(message = "kindly provide the product global price")
    private BigDecimal globalPrice;
    @NotNull(message = "kindly provide the product sale price")
    @NotBlank(message = "kindly provide the product sale price")
    @NotEmpty(message = "kindly provide the product sale price")
    private BigDecimal salePrice;
    @NotNull(message = "kindly provide the product currency")
    @NotBlank(message = "kindly provide the product currency")
    @NotEmpty(message = "kindly provide the product currency")
    private PriceCurrency priceCurrency;
}
