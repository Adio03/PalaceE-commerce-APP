package com.example.palaceecommerceapp.dtos.responses;

import com.example.palaceecommerceapp.data.models.PriceCurrency;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class PriceResponse {
    private BigDecimal globalPrice;
    private BigDecimal salePrice;
    private PriceCurrency priceCurrency;
}
