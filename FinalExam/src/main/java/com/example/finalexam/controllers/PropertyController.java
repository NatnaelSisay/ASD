package com.example.finalexam.controllers;

import com.example.finalexam.dtos.property.PropertyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    @GetMapping("/{state}")
    public ResponseEntity<List<PropertyDTO>> getPropertiesOfGivenState(@PathVariable String state) {
        return ResponseEntity.ok(null);
    }

    
}
