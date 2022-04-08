package com.example.Vitarico.exception;

import com.example.Vitarico.exception.personalized.CustomerException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.example.Vitarico.exception.personalized.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleApiRequest {

    @ExceptionHandler(value = {CustomerException.class})
    public ResponseEntity<Object> customerNotFound(CustomerException e){
        ApiException apiException = new ApiException(
            e.getMessage(),
            HttpStatus.NOT_FOUND,
            ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = {ProductException.class})
    public ResponseEntity<Object> productNotFound(ProductException e){
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

}
