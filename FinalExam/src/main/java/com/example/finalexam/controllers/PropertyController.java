package com.example.finalexam.controllers;

import com.example.finalexam.dtos.property.PropertyDTO;
import com.example.finalexam.dtos.property.PropertyRequest;
import com.example.finalexam.services.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> findAll() {
        List<PropertyDTO> propertyDTOS = this.propertyService.findAll();
        return ResponseEntity.ok(propertyDTOS);
    }

    @GetMapping(value = "/{state}")
    public ResponseEntity<List<PropertyDTO>> getPropertiesOfGivenState(
            @PathVariable String state
    ) {
        List<PropertyDTO> propertyDTOS = this.propertyService.findAllByState(state);
        return ResponseEntity.ok(propertyDTOS);
    }


    @PostMapping
    public ResponseEntity<PropertyDTO> saveProperty(
            @RequestBody PropertyRequest property
    ) {
        PropertyDTO propertyDTO = this.propertyService.save(property);
        return ResponseEntity.ok(propertyDTO);
    }

}
