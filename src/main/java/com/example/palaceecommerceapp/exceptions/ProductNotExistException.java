package com.example.palaceecommerceapp.exceptions;

public class ProductNotExistException extends MerchantException {
    public ProductNotExistException(String message) {
        super(message);
    }

    public ProductNotExistException(Throwable throwable) {
        super(throwable);
    }
}
