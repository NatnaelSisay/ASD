package com.example.mockfinal.dtos.employee;

// - Used to create new user
public record EmployeeRequest(
        String firstName,
        String lastName,
        Double yearlySalary
) {
}
