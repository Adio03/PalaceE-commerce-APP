package com.example.palaceecommerceapp.exceptions;

public class InvalidWalletAddressException extends MerchantException{
    public InvalidWalletAddressException(String message) {
        super(message);
    }

    public InvalidWalletAddressException(Throwable throwable) {
        super(throwable);
    }
}
