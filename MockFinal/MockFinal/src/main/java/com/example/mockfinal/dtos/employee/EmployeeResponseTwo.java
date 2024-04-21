package com.example.mockfinal.dtos.employee;

// - User in retirement response
public record EmployeeResponseTwo(
        Long employeeId,
        String firstName,
        String lastName,
        Double yearlySalary
) {
}
