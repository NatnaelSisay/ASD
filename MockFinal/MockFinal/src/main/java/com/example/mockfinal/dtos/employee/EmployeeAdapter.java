package com.example.mockfinal.dtos.employee;

import com.example.mockfinal.dtos.retirement.RetirementAdapter;
import com.example.mockfinal.models.Employee;
import com.example.mockfinal.models.RetirementPlan;

public class EmployeeAdapter {
    public static EmployeeResponse getEmployeeResponseFromEmployee(Employee employee) {
        if (employee == null) return null;

        RetirementPlan plan = employee.getRetirementPlan();

        EmployeeResponse result = new EmployeeResponse(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getYearlySalary(),
                RetirementAdapter.getRetirementResponse(plan)
        );

        return result;
    }

    public static EmployeeResponseTwo getEmployeeResponseTwoFromEmployee(Employee employee) {
        if (employee == null) return null;

        EmployeeResponseTwo result = new EmployeeResponseTwo(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getYearlySalary()
        );

        return result;
    }

    public static Employee getEmployeeFromRequest(EmployeeRequest employeeRequest) {
        Employee employee = new Employee(
                employeeRequest.firstName(),
                employeeRequest.lastName(),
                employeeRequest.yearlySalary()
        );

        RetirementPlan retirementPlan = RetirementAdapter.getRetirementFromRetirementRequest(employeeRequest.retirement());
        employee.setRetirementPlan(retirementPlan);

        return employee;
    }
}
