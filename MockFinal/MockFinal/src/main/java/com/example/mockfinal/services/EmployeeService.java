package com.example.mockfinal.services;

import com.example.mockfinal.dtos.employee.EmployeeRequest;
import com.example.mockfinal.dtos.employee.EmployeeResponse;

import java.util.List;


public interface EmployeeService {
    public EmployeeResponse save(EmployeeRequest employee);

    public List<EmployeeResponse> finAll();

    public List<EmployeeResponse> findNextRetiree();
}
