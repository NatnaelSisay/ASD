package com.example.finalexam.services;

import com.example.finalexam.dtos.RevenueDTO;
import com.example.finalexam.dtos.lease.LeaseDTO;
import com.example.finalexam.dtos.lease.LeaseRequest;
import com.example.finalexam.dtos.lease.LeaseResponse;

import java.util.List;

public interface LeaseService {
    public List<LeaseDTO> findAll();

    public RevenueDTO getRevenue(String state);

    public LeaseDTO save(LeaseRequest lease, Integer propertyId);
}
