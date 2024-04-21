package com.example.mockfinal.dtos.employee;

import com.example.mockfinal.dtos.retirement.RetirementRequest;

// - Used to create new user
public record EmployeeRequest(
        String firstName,
        String lastName,
        Double yearlySalary,
        RetirementRequest retirement
) {
}
