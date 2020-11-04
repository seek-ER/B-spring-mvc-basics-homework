package com.thoughtworks.capacity.gtb.mvc.error;

public class UserExistException extends RuntimeException {
    public UserExistException(String message) {
        super(message);
    }
}
