package com.example.finalexam.dtos.property;

public record PropertyResponse(
        Long propertyId,
        String propertyRef,
        String city,
        String state,
        Double monthlyRentalRate
) {
}
