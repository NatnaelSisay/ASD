package com.example.ecommerce.security;

public record AuthRequest(
        String email,
        String password
) {
}
