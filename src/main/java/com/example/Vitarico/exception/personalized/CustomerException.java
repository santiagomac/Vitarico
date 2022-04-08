package com.example.Vitarico.exception.personalized;

public class CustomerException extends RuntimeException{

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }
}
