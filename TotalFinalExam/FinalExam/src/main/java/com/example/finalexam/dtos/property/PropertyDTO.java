package com.example.finalexam.dtos.property;

import com.example.finalexam.dtos.lease.LeaseResponse;

import java.util.List;

public record PropertyDTO(
        Integer propertyId,
        String propertyRef,
        String city,
        String state,
        Double monthlyRentalRate,
        List<LeaseResponse> lease
) {
}
