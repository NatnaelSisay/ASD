package com.example.dentalappointment.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ItemNotFoundResponse(
        String message,
        HttpStatus statusCode,
        ZonedDateTime timestamp
) {
}
