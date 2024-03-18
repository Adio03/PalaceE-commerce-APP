package com.example.palaceecommerceapp.exceptions;

public class StoreAlreadyExistException extends MerchantException{

    public StoreAlreadyExistException(String message) {
        super(message);
    }

    public StoreAlreadyExistException(Throwable throwable) {
        super(throwable);
    }
}
