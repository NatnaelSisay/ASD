package com.example.ecommerce.servicies;

import com.example.ecommerce.dtos.role.RoleRequest;
import com.example.ecommerce.dtos.role.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> findAll();

    RoleResponse save(RoleRequest roleRequest);
}
