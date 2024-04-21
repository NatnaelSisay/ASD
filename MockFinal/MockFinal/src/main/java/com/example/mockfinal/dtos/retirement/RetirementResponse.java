package com.example.mockfinal.dtos.retirement;

import java.time.LocalDate;

// - Used in employee response
public record RetirementResponse(
        Long planId,
        String referenceNumber,
        LocalDate enrollmentDate,
        LocalDate retirementDate,
        Double monthlyContribution
) {
}
