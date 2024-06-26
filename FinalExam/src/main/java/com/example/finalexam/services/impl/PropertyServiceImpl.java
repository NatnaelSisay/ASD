package com.example.finalexam.services.impl;

import com.example.finalexam.dtos.property.PropertyAdapter;
import com.example.finalexam.dtos.property.PropertyDTO;
import com.example.finalexam.dtos.property.PropertyRequest;
import com.example.finalexam.models.Property;
import com.example.finalexam.reporitory.PropertyRepository;
import com.example.finalexam.services.PropertyService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
    public List<PropertyDTO> findAll() {
        List<Property> properties = this.repository.findAll();
        List<PropertyDTO> propertyResponses = PropertyAdapter.getPropertyDTOListfromProperties(properties);
        return propertyResponses;
    }

    @Override
    public List<PropertyDTO> findAllByState(String state) {
        List<Property> properties = this.repository.findByState(state);
        List<PropertyDTO> propertyResponses = PropertyAdapter.getPropertyDTOListfromProperties(properties);

        propertyResponses = propertyResponses.stream().sorted(
                Comparator.comparing(PropertyDTO::monthlyRentalRate)
        ).toList();

        return propertyResponses;
    }

    @Override
    public PropertyDTO save(PropertyRequest propertyRequest) {
        Property property = PropertyAdapter.getPropertyFromRequest(propertyRequest);
        property = this.repository.save(property);

        PropertyDTO propertyResponse = PropertyAdapter.getPropertyDTOFromProperty(property);
        return propertyResponse;
    }
}
