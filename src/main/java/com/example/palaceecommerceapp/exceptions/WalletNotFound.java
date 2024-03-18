package com.example.palaceecommerceapp.exceptions;

public class WalletNotFound extends MerchantException {

    public WalletNotFound(String message) {
        super(message);
    }

    public WalletNotFound(Throwable throwable) {
        super(throwable);
    }
}
