package com.example.palaceecommerceapp.exceptions;

public class StoreNotFoundException extends MerchantException{
    public StoreNotFoundException(String message) {
        super(message);
    }

    public StoreNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
