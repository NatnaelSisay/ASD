package com.example.finalexam.dtos.lease;

import com.example.finalexam.dtos.property.PropertyResponse;

import java.time.LocalDate;

public record LeaseDTO(
        Long leaseId,
        Long leaseReferenceNumber,
        LocalDate startDate,
        LocalDate endDate,
        PropertyResponse property
) {
}
