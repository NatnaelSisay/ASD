package com.example.ecommerce.servicies.impl;

import com.example.ecommerce.dtos.role.RoleAdapter;
import com.example.ecommerce.dtos.role.RoleRequest;
import com.example.ecommerce.dtos.role.RoleResponse;
import com.example.ecommerce.models.Role;
import com.example.ecommerce.repositories.RoleRepository;
import com.example.ecommerce.servicies.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleResponse> findAll() {
        List<Role> roles = this.roleRepository.findAll();
        return RoleAdapter.getRoleResponseListFromRoles(roles);
    }

    @Override
    public RoleResponse save(RoleRequest roleRequest) {
        Role role = RoleAdapter.getRoleFromRequest(roleRequest);
        role = this.roleRepository.save(role);

        return RoleAdapter.getRoleResponseListFromRoles(role);
    }
}
