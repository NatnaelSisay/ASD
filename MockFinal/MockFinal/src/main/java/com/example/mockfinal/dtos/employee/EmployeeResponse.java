package com.example.mockfinal.dtos.employee;

import com.example.mockfinal.dtos.retirement.RetirementResponse;

// - Used to return a user or list of users
public record EmployeeResponse(
        Long employeeId,
        String firstName,
        String lastName,
        Double yearlySalary,
        RetirementResponse retirement
) {
}
