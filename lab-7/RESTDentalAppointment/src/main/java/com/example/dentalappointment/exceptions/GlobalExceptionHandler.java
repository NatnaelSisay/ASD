package com.example.dentalappointment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ItemNotFoundResponse> handleItemNotFoundException(ItemNotFound error) {
        ItemNotFoundResponse result = new ItemNotFoundResponse(error.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

}
