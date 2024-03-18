package com.example.palaceecommerceapp.exceptions;

public class MerchantException extends Throwable{
    public MerchantException(String message) {
        super(message);
    }
    public  MerchantException(Throwable throwable){
        super(throwable);
    }
}
