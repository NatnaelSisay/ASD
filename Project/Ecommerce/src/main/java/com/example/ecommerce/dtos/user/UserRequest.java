package com.example.ecommerce.dtos.user;

import com.example.ecommerce.models.Address;

public record UserRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String roles,
        Address address
) {
}
