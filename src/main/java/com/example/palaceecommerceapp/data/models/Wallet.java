package com.example.palaceecommerceapp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long merchantId;
    @Column(nullable = false)
    private BigDecimal balance;
    @OneToMany
    private List<Transaction> transaction;

}