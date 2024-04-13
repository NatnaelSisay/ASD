package com.example.dentalappointment.exceptions;

public record ItemNotFoundResponse(
        String message,
        Integer statusCode
) {
}
