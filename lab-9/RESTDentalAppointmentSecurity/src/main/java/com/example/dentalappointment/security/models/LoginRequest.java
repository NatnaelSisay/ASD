package com.example.dentalappointment.security.models;

public record LoginRequest(
        String email,
        String password
) {
}
