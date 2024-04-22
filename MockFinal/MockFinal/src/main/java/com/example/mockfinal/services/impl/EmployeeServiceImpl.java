package com.example.mockfinal.services.impl;

import com.example.mockfinal.dtos.employee.EmployeeAdapter;
import com.example.mockfinal.dtos.employee.EmployeeRequest;
import com.example.mockfinal.dtos.employee.EmployeeResponse;
import com.example.mockfinal.models.Employee;
import com.example.mockfinal.repositories.EmployeeRepository;
import com.example.mockfinal.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    @Override
    public EmployeeResponse save(EmployeeRequest employee) {
        Employee emp = EmployeeAdapter.getEmployeeFromRequest(employee);
        emp = this.repository.save(emp);

        return EmployeeAdapter.getEmployeeResponseFromEmployee(emp);
    }

    @Override
    public List<EmployeeResponse> finAll() {
        List<Employee> employees = this.repository.findAll();
        return EmployeeAdapter.getEmployeeResponseList(employees);
    }

    @Override
    public List<EmployeeResponse> findNextRetiree() {
        List<Employee> employees = this.repository.findAll();
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        int nYear = nextMonth.getYear();
        int nMonth = nextMonth.getMonthValue();

        List<Employee> result = employees.stream().filter(employee -> {

            LocalDate rDate = employee.getRetirementPlan().getRetirementDate();
            System.out.println(rDate);
            if (rDate.getYear() > nYear || rDate.getYear() < nYear) {
                return false;
            }
            if (rDate.getMonthValue() != nMonth) {
                return false;
            }
            return true;
        }).toList();

        result = result.stream().sorted(Comparator.comparing(a -> a.getRetirementPlan().getRetirementDate())).toList();

        return EmployeeAdapter.getEmployeeResponseList(result);
    }
}
