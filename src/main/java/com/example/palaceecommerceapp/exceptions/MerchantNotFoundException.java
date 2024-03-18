package com.example.palaceecommerceapp.exceptions;

public class MerchantNotFoundException extends MerchantException{
    public MerchantNotFoundException(String message) {
        super(message);
    }

    public MerchantNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
