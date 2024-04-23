package com.example.ecommerce.dtos.user;

public record UserDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String password,
        String roles
) {
}
