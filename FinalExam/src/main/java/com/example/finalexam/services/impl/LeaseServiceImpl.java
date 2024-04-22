package com.example.finalexam.services.impl;

import com.example.finalexam.dtos.RevenueDTO;
import com.example.finalexam.dtos.lease.LeaseDTO;
import com.example.finalexam.dtos.lease.LeaseRequest;
import com.example.finalexam.dtos.lease.LeaseResponse;
import com.example.finalexam.services.LeaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseServiceImpl implements LeaseService {
    @Override
    public List<LeaseResponse> findAll() {
        return null;
    }

    @Override
    public RevenueDTO getRevenue(String state) {
        return null;
    }

    @Override
    public LeaseDTO save(LeaseRequest lease, Integer propertyId) {
        return null;
    }
}
