package com.example.mockfinal.controllers;

import com.example.mockfinal.dtos.retirement.RetirementResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/retirements")
public class RetirementController {

    @GetMapping("/emp/{employeeId}")
    public ResponseEntity<RetirementResponse> getRetirement(@PathVariable Long employeeId) {
        return ResponseEntity.ok(null);
    }
}
