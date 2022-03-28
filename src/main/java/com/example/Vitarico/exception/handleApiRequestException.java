package com.example.Vitarico.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class handleApiRequestException {

    @ExceptionHandler(value = {CustomerException.class})
    public ResponseEntity<Object> handleApiRequestException(CustomerException e){
        ApiException apiException = new ApiException(
            e.getMessage(),
            HttpStatus.NOT_FOUND,
            ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

}
