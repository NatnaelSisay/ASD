package com.example.dentalappointment.security.models;

public record LoginResponse(
        String token,
        String firstName,
        String lastName,
        String email
) {
}
