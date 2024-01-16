package com.alkimin.testifoodapi.application.product.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
