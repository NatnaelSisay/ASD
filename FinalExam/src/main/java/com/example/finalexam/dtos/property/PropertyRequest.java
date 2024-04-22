package com.example.finalexam.dtos.property;

import com.example.finalexam.dtos.lease.LeaseRequest;

public record PropertyRequest(
        Long propertyId,
        String propertyRef,
        String city,
        String state,
        Double monthlyRentalRate,
        LeaseRequest lease
) {
}
