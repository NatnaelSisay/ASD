package com.example.mockfinal.controllers;

import com.example.mockfinal.dtos.retirement.RetirementDTO;
import com.example.mockfinal.services.RetirementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/retirements")
public class RetirementController {
    RetirementService service;

    public RetirementController(
            RetirementService service
    ) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RetirementDTO> getRetirement(@PathVariable Long id) {
        RetirementDTO retirementDTO = this.service.getRetirement(id);
        return ResponseEntity.ok(retirementDTO);
    }
}
