package com.example.ecommerce.security;

public record AuthResponse(
        String token,
        String firstName,
        String lastName,
        String email
) {
}
