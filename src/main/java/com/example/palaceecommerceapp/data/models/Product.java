package com.example.palaceecommerceapp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@Entity
@ToString
@Table(name = "product_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String productName;
    private String productImageURl;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categories categories;
    @Column(nullable = false)
    private String description;
    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Price price;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Long merchantId;
    @Column(nullable = false)
    private Long storeId;

}
