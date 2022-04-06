package com.example.Vitarico.exception;

public class CustomerException extends RuntimeException{

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }
}