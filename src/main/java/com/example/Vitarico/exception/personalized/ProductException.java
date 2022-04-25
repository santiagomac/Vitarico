package com.example.Vitarico.exception.personalized;

public class ProductException extends RuntimeException{

    public ProductException(String message){
        super(message);
    }

    public ProductException(String message, Throwable cause){
        super(message, cause);
    }
}
