package com.example.finalexam.dtos.property;

import com.example.finalexam.dtos.lease.LeaseResponse;

public record PropertyDTO(
        Long propertyId,
        String propertyRef,
        String city,
        String state,
        Double monthlyRentalRate,
        LeaseResponse lease
) {
}
