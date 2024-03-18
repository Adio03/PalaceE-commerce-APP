package com.example.palaceecommerceapp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name ="store_table")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String storeName;
    @Column(nullable = false,unique = true)
    private String storeUrl;
    @Column(nullable = false)
    private String storeDescription;
    @Column(nullable = false,unique = true)
    private Long merchantId;
}
