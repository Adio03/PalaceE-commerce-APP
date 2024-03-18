package com.example.palaceecommerceapp.data.repositories;

import com.example.palaceecommerceapp.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findProductByProductName(String productName);
}
