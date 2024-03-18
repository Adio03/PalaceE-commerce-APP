package com.example.palaceecommerceapp.exceptions;

public class MerchantFoundException extends MerchantException{
    public MerchantFoundException(String message) {
        super(message);
    }

    public MerchantFoundException(Throwable throwable) {
        super(throwable);
    }
}
