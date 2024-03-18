package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.data.models.Categories;
import com.example.palaceecommerceapp.data.models.PriceCurrency;
import com.example.palaceecommerceapp.dtos.requests.PriceRequest;
import com.example.palaceecommerceapp.dtos.requests.ProductRequest;
import com.example.palaceecommerceapp.dtos.responses.ProductResponse;
import com.example.palaceecommerceapp.exceptions.ImageUploadException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.ProductNotExistException;
import com.example.palaceecommerceapp.exceptions.StoreNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;

import static com.example.palaceecommerceapp.data.models.Categories.CLOTHES;
import static com.example.palaceecommerceapp.data.models.PriceCurrency.NGN;
import static com.example.palaceecommerceapp.services.CloudinaryTest.getFileTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class ProductTest {
    @Autowired
    private ProductService productService;
    private ProductRequest productRequest;
    private PriceRequest priceRequest;
    public static String IMAGE_LOCATION = "C:\\Users\\mr Adio\\IdeaProjects\\PalaceE-commerce-App\\src\\main\\resources\\assets\\Garri.jpeg";
    @BeforeEach
    void startWith(){
        productRequest = new ProductRequest();
        priceRequest = new PriceRequest();

        priceRequest.setGlobalPrice(new BigDecimal("100.00"));
        priceRequest.setSalePrice(new BigDecimal("80.00"));
        priceRequest.setPriceCurrency(NGN);

        productRequest.setProductName("Lace");
        productRequest.setProductImage(getFileTest(IMAGE_LOCATION));
        productRequest.setCategories(CLOTHES);
        productRequest.setDescription("Lace Material");
        productRequest.setPriceRequest(priceRequest);
        productRequest.setQuantity(50);
        productRequest.setMerchantId(1L);
        productRequest.setStoreId(1L);
    }
    @Test
    public void addProductToStoreTest() throws StoreNotFoundException, MerchantNotFoundException, ImageUploadException {
        ProductResponse productResponse = productService.addProductToStore(productRequest);
        assertNotNull(productResponse);
        assertNotNull(productResponse.getMessage());
    }
    @Test
    public void getProductByNameTest() throws ProductNotExistException {
        String productName ="Senator";
        assertNotNull(productService.getProductByName(productName));
    }
    @Test
//    @Sql("/insert.sql")
    public void getUsers(){
        List<ProductResponse> users = productService.getAllProduct(1, 5);
        log.info("Product:: {}", users);
        assertThat(users).hasSize(5);

    }
}
