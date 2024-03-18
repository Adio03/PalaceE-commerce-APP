package com.example.palaceecommerceapp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@ToString
@Table(name ="product_price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal globalPrice;
    @Column(nullable = false)
    private BigDecimal salePrice;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PriceCurrency priceCurrency;

}
