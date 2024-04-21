package com.example.mockfinal.dtos.retirement;

import com.example.mockfinal.dtos.employee.EmployeeResponseTwo;

import java.time.LocalDate;

// - Used to get Retirement or list of retirement
public record RetirementDTO(
        Long planId,
        String referenceNumber,
        LocalDate enrollmentDate,
        LocalDate retirementDate,
        Double monthlyContribution,
        EmployeeResponseTwo employee
) {
}
