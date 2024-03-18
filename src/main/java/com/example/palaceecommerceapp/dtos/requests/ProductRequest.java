package com.example.palaceecommerceapp.dtos.requests;

import com.example.palaceecommerceapp.data.models.Categories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter

public class ProductRequest {
    private MultipartFile productImage;
    @NotNull(message = "kindly provide the product name")
    @NotBlank(message = "kindly provide the product name")
    @NotEmpty(message = "kindly provide the product name")
    private String productName;
    @NotNull(message = "kindly provide the product categories")
    @NotBlank(message = "kindly provide the product categories")
    @NotEmpty(message = "kindly provide the product categories")
    private Categories categories;
    @NotNull(message = "kindly provide the product description")
    @NotBlank(message = "kindly provide the product description")
    @NotEmpty(message = "kindly provide the product description")
    private String description;
    @NotNull(message = "kindly provide the product price")
    @NotBlank(message = "kindly provide the product price")
    @NotEmpty(message = "kindly provide the product price")
    private PriceRequest priceRequest;
    @NotNull(message = "kindly provide the product quantity")
    @NotBlank(message = "kindly provide the product quantity")
    @NotEmpty(message = "kindly provide the product quantity")
    private Integer quantity;
    private Long merchantId;
    private Long storeId;



}
