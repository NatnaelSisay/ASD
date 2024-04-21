package com.example.mockfinal.dtos.retirement;

import com.example.mockfinal.dtos.employee.EmployeeAdapter;
import com.example.mockfinal.models.Employee;
import com.example.mockfinal.models.RetirementPlan;

public class RetirementAdapter {

    public static RetirementResponse getRetirementResponse(RetirementPlan plan) {
        if (plan == null) return null;

        RetirementResponse result = new RetirementResponse(
                plan.getPlanId(),
                plan.getReferenceNumber(),
                plan.getEnrollmentDate(),
                plan.getRetirementDate(),
                plan.getMonthlyContribution()
        );

        return result;
    }

    public static RetirementDTO getRetirementDTOFromRetirement(RetirementPlan plan) {
        if (plan == null) return null;
        Employee employee = plan.getEmployee();

        RetirementDTO result = new RetirementDTO(
                plan.getPlanId(),
                plan.getReferenceNumber(),
                plan.getEnrollmentDate(),
                plan.getRetirementDate(),
                plan.getMonthlyContribution(),
                EmployeeAdapter.getEmployeeResponseTwoFromEmployee(employee)
        );

        return result;
    }

    public static RetirementPlan getRetirementFromRetirementRequest(RetirementRequest retirementRequest) {
        RetirementPlan plan = new RetirementPlan(
                retirementRequest.referenceNumber(),
                retirementRequest.enrollmentDate(),
                retirementRequest.retirementDate()
        );

        return plan;
    }
}
