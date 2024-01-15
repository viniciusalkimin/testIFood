package com.alkimin.testifoodapi.application.category.exception;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(String msg) {
        super(msg);
    }
}
