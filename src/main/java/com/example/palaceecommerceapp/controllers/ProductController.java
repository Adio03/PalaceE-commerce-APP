package com.example.palaceecommerceapp.controllers;

import com.example.palaceecommerceapp.dtos.requests.ProductRequest;
import com.example.palaceecommerceapp.dtos.responses.ProductResponse;
import com.example.palaceecommerceapp.exceptions.ImageUploadException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.StoreNotFoundException;
import com.example.palaceecommerceapp.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody @Valid ProductRequest productRequest) throws StoreNotFoundException, MerchantNotFoundException, ImageUploadException {
        ProductResponse productResponse = productService.addProductToStore(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{page}/{size}")
    public ResponseEntity<?> getProducts(@PathVariable int page, @PathVariable int size){
        return ResponseEntity.ok(productService.getAllProduct(page, size));
    }
}
