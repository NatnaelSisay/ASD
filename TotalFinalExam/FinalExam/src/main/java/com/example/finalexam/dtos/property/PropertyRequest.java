package com.example.finalexam.dtos.property;

public record PropertyRequest(
        String propertyRef,
        String city,
        String state,
        Double monthlyRentalRate
) {
}
