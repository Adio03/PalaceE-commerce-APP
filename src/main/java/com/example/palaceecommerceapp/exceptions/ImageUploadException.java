package com.example.palaceecommerceapp.exceptions;

public class ImageUploadException extends MerchantException {

    public ImageUploadException(String message) {
        super(message);
    }

    public ImageUploadException(Throwable throwable) {
        super(throwable);
    }
}
