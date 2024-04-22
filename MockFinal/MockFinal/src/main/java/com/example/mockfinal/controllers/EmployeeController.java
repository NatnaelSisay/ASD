package com.example.mockfinal.controllers;

import com.example.mockfinal.dtos.employee.EmployeeRequest;
import com.example.mockfinal.dtos.employee.EmployeeResponse;
import com.example.mockfinal.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> findAll() {
        List<EmployeeResponse> response = this.employeeService.finAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nextretirees")
    public ResponseEntity<List<EmployeeResponse>> findNextRetirees() {
        List<EmployeeResponse> response = this.employeeService.findNextRetiree();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> save(@RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse employee = this.employeeService.save(employeeRequest);
        return ResponseEntity.ok(employee);
    }

}
