package com.example.finalexam.dtos.property;

import com.example.finalexam.dtos.lease.LeaseAdapter;
import com.example.finalexam.dtos.lease.LeaseResponse;
import com.example.finalexam.models.Property;

import java.util.List;

public class PropertyAdapter {

    public static Property getPropertyFromRequest(PropertyRequest propertyRequest) {
        if (propertyRequest == null) return null;

        Property response = new Property(
                propertyRequest.propertyRef(),
                propertyRequest.city(),
                propertyRequest.state(),
                propertyRequest.monthlyRentalRate()
        );

        return response;
    }

    public static PropertyDTO getPropertyDTOFromProperty(Property property) {
        if (property == null) return null;
        List<LeaseResponse> leaseResponse = LeaseAdapter.getLeasesResponseFromLease(property.getLeases());

        PropertyDTO propertyDTO = new PropertyDTO(
                property.getPropertyId(),
                property.getPropertyRef(),
                property.getCity(),
                property.getState(),
                property.getMonthlyRentalRate(),
                leaseResponse
        );

        return propertyDTO;
    }

    public static PropertyResponse getPropertyResponseFromProperty(Property property) {
        if (property == null) return null;

        PropertyResponse propertyResponse = new PropertyResponse(
                property.getPropertyId(),
                property.getPropertyRef(),
                property.getCity(),
                property.getState(),
                property.getMonthlyRentalRate()
        );

        return propertyResponse;
    }
}
