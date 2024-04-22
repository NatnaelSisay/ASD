package com.example.finalexam.dtos.lease;

import java.time.LocalDate;

public record LeaseRequest(
        Long leaseReferenceNumber,
        LocalDate startDate,
        LocalDate endDate
) {
}
