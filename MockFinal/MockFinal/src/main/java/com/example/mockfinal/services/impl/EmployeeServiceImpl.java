package com.example.mockfinal.services.impl;

import com.example.mockfinal.dtos.employee.EmployeeAdapter;
import com.example.mockfinal.dtos.employee.EmployeeRequest;
import com.example.mockfinal.dtos.employee.EmployeeResponse;
import com.example.mockfinal.models.Employee;
import com.example.mockfinal.repositories.EmployeeRepository;
import com.example.mockfinal.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository repository;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository
    ) {
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
//        find list of employees, and from those find the retirement
        return null;
    }
}
