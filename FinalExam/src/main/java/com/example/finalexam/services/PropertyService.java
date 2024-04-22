package com.example.finalexam.services;

import com.example.finalexam.dtos.property.PropertyDTO;
import com.example.finalexam.dtos.property.PropertyRequest;

import java.util.List;

public interface PropertyService {
    public List<PropertyDTO> findAllByState(String state);

    PropertyDTO save(PropertyRequest property);
}
