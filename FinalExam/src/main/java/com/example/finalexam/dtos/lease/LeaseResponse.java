package com.example.finalexam.dtos.lease;

import java.time.LocalDate;

public record LeaseResponse(
        Long leaseId,
        Long leaseReferenceNumber,
        LocalDate startDate,
        LocalDate endDate
) {
}
