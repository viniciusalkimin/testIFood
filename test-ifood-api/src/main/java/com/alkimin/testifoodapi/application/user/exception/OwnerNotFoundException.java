package com.alkimin.testifoodapi.application.user.exception;

public class OwnerNotFoundException extends RuntimeException {

    public OwnerNotFoundException(String msg) {
        super(msg);
    }
}
