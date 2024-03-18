package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.data.models.Product;
import com.example.palaceecommerceapp.dtos.requests.ProductRequest;
import com.example.palaceecommerceapp.dtos.responses.ProductResponse;
import com.example.palaceecommerceapp.exceptions.ImageUploadException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.ProductNotExistException;
import com.example.palaceecommerceapp.exceptions.StoreNotFoundException;

import java.util.List;

public interface ProductService {
    Product getProductByName(String productName) throws ProductNotExistException;
    ProductResponse addProductToStore(ProductRequest productRequest) throws MerchantNotFoundException, StoreNotFoundException, ImageUploadException;
    List<ProductResponse> getAllProduct(int page, int size);
}
