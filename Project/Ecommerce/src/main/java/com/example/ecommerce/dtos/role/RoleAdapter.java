package com.example.ecommerce.dtos.role;

import com.example.ecommerce.models.Role;

import java.util.List;

public class RoleAdapter {

    public static RoleResponse getRoleResponseListFromRoles(Role roles) {
        RoleResponse response = new RoleResponse(
                roles.getId(),
                roles.getName()
        );

        return response;
    }

    public static List<RoleResponse> getRoleResponseListFromRoles(List<Role> roles) {
        return roles.stream().map(r -> getRoleResponseListFromRoles(r)).toList();
    }

    public static Role getRoleFromRequest(RoleRequest roleRequest) {
        return new Role(roleRequest.name());
    }
}
