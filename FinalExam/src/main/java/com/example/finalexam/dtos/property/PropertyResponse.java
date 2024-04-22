package com.example.finalexam.dtos.property;

public record PropertyResponse(
        Integer propertyId,
        String propertyRef,
        String city,
        String state,
        Double monthlyRentalRate
) {
}
