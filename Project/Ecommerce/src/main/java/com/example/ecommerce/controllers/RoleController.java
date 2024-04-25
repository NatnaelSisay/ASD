package com.example.ecommerce.controllers;

import com.example.ecommerce.dtos.ResponseData;
import com.example.ecommerce.dtos.ResponseDataList;
import com.example.ecommerce.dtos.role.RoleRequest;
import com.example.ecommerce.dtos.role.RoleResponse;
import com.example.ecommerce.servicies.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<ResponseDataList> findAll() {
        List<RoleResponse> response = this.roleService.findAll();
        return ResponseEntity.ok(new ResponseDataList(response));
    }

    @PostMapping
    public ResponseEntity<ResponseData> save(
            @RequestBody RoleRequest roleRequest
    ) {
        System.out.println(roleRequest);
        RoleResponse response = this.roleService.save(roleRequest);
        return ResponseEntity.ok(new ResponseData(response));
    }
}
