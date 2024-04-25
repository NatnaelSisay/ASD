package com.example.ecommerce.dtos.user;

import com.example.ecommerce.dtos.role.RoleResponse;

import java.util.List;

public record UserDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String password,
        List<RoleResponse> roles
) {
}
