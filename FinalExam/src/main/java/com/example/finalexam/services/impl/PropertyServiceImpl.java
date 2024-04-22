package com.example.finalexam.services.impl;

import com.example.finalexam.dtos.property.PropertyDTO;
import com.example.finalexam.dtos.property.PropertyRequest;
import com.example.finalexam.services.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Override
    public List<PropertyDTO> findAllByState(String state) {
        return null;
    }

    @Override
    public PropertyDTO save(PropertyRequest property) {
        return null;
    }
}
