package com.example.mockfinal.controllers;

import com.example.mockfinal.dtos.employee.EmployeeRequest;
import com.example.mockfinal.dtos.employee.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> findAll() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/nextretirees")
    public ResponseEntity<List<EmployeeResponse>> findNextRetirees() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> save(@RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(null);
    }


}
