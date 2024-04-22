package com.example.finalexam.services.impl;

import com.example.finalexam.dtos.property.PropertyAdapter;
import com.example.finalexam.dtos.property.PropertyDTO;
import com.example.finalexam.dtos.property.PropertyRequest;
import com.example.finalexam.models.Property;
import com.example.finalexam.reporitory.PropertyRepository;
import com.example.finalexam.services.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    PropertyRepository repository;

    public PropertyServiceImpl(
            PropertyRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public List<PropertyDTO> findAllByState(String state) {
        return null;
    }

    @Override
    public PropertyDTO save(PropertyRequest propertyRequest) {
        Property property = PropertyAdapter.getPropertyFromRequest(propertyRequest);
        property = this.repository.save(property);

        PropertyDTO propertyResponse = PropertyAdapter.getPropertyDTOFromProperty(property);
        return propertyResponse;
    }
}
