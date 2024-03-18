package com.example.palaceecommerceapp.services;

import com.example.palaceecommerceapp.data.models.Merchant;
import com.example.palaceecommerceapp.data.models.Price;
import com.example.palaceecommerceapp.data.models.Product;
import com.example.palaceecommerceapp.data.models.Store;
import com.example.palaceecommerceapp.data.repositories.ProductRepository;
import com.example.palaceecommerceapp.dtos.requests.ProductRequest;
import com.example.palaceecommerceapp.dtos.responses.PriceResponse;
import com.example.palaceecommerceapp.dtos.responses.ProductResponse;
import com.example.palaceecommerceapp.exceptions.ImageUploadException;
import com.example.palaceecommerceapp.exceptions.MerchantNotFoundException;
import com.example.palaceecommerceapp.exceptions.ProductNotExistException;
import com.example.palaceecommerceapp.exceptions.StoreNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import static com.example.palaceecommerceapp.utils.Mapper.map;

@Service
@Slf4j
@AllArgsConstructor
public class PalaceProductService implements ProductService {
    private ProductRepository productRepository;
    private MerchantService merchantService;
    private StoreService storeService;
    private ModelMapper modelMapper;
    private CloudinaryService cloudinaryService;




    @Override
    public ProductResponse addProductToStore(ProductRequest productRequest) throws MerchantNotFoundException, StoreNotFoundException, ImageUploadException {
            Merchant merchant = merchantService.getMerchantById(productRequest.getMerchantId());
        Store store = storeService.getStoreById(productRequest.getStoreId());
        Price price = map(productRequest.getPriceRequest());
        String imageResponse = cloudinaryService.upload(productRequest.getProductImage());
        Product product = new Product();
        product.setProductImageURl(imageResponse);
        product.setProductName(productRequest.getProductName());
        product.setCategories(productRequest.getCategories());
        product.setDescription(productRequest.getDescription());
        product.setQuantity(productRequest.getQuantity());
        product.setMerchantId(merchant.getId());
        product.setStoreId(store.getId());
        product.setPrice(price);
        var savedProduct = productRepository.save(product);
        return productResponse(savedProduct);
    }
    private ProductResponse productResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getId());
        productResponse.setMerchantId(product.getMerchantId());
        productResponse.setStoreId(product.getStoreId());
        productResponse.setProductPrice(priceResponse(product.getPrice()));
        productResponse.setMessage("product Posted successfully");
        return productResponse;
    }
    private PriceResponse priceResponse(Price price) {
        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setGlobalPrice(price.getGlobalPrice());
        priceResponse.setSalePrice(price.getSalePrice());
        priceResponse.setPriceCurrency(price.getPriceCurrency());
        return priceResponse;
    }


    @Override
    public List<ProductResponse> getAllProduct(int page, int size) {
        Pageable pageable = PageRequest.of(page -1,size);
        Page<Product> productPage = productRepository.findAll(pageable);
        List<Product> products = productPage.getContent();
        log.info("Product :: {}",products);
        return products.stream().
                map(product -> modelMapper.map(product,ProductResponse.class)).toList();
    }


    @Override
    public Product getProductByName(String productName) throws ProductNotExistException {
        Product product = productRepository.findProductByProductName(productName).
                orElseThrow(()-> new ProductNotExistException("the product does not exist"));
        log.info("Product :: {} ",product);
        return product;
    }
}