package com.thoughtworks.capacity.gtb.mvc.error;

public class PasswordNotMatchException extends RuntimeException {
    public PasswordNotMatchException(String message) {
        super(message);
    }
}
