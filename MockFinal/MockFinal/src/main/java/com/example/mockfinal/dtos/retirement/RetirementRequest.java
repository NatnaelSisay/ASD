package com.example.mockfinal.dtos.retirement;

import java.time.LocalDate;

public record RetirementRequest(
        String referenceNumber,
        LocalDate enrollmentDate,
        LocalDate retirementDate,
        Double monthlyContribution
) {
}
