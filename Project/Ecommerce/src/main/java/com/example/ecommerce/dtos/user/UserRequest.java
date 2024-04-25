package com.example.ecommerce.dtos.user;

import com.example.ecommerce.models.Address;
import com.example.ecommerce.models.Role;

import java.util.List;

public record UserRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        List<Role> roles,
        Address address
) {
}
