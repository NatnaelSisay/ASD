package com.example.ecommerce.repositories;

import com.example.ecommerce.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
