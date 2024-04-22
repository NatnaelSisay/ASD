package com.example.mockfinal.services.impl;

import com.example.mockfinal.dtos.employee.EmployeeRequest;
import com.example.mockfinal.dtos.employee.EmployeeResponse;
import com.example.mockfinal.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public EmployeeResponse save(EmployeeRequest employee) {
        return null;
    }

    @Override
    public List<EmployeeResponse> finAll() {
        return null;
    }

    @Override
    public List<EmployeeResponse> findNextRetiree() {
        return null;
    }
}
