package com.example.finalexam.services.impl;

import com.example.finalexam.dtos.RevenueDTO;
import com.example.finalexam.dtos.lease.LeaseAdapter;
import com.example.finalexam.dtos.lease.LeaseDTO;
import com.example.finalexam.dtos.lease.LeaseRequest;
import com.example.finalexam.models.Lease;
import com.example.finalexam.models.Property;
import com.example.finalexam.reporitory.LeaseRepository;
import com.example.finalexam.reporitory.PropertyRepository;
import com.example.finalexam.services.LeaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseServiceImpl implements LeaseService {
    LeaseRepository leaseRepository;
    PropertyRepository propertyRepository;

    public LeaseServiceImpl(
            LeaseRepository leaseRepository,
            PropertyRepository propertyRepository
    ) {
        this.leaseRepository = leaseRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<LeaseDTO> findAll() {
        List<Lease> leaseList = this.leaseRepository.findAll();
        List<LeaseDTO> leaseResponses = LeaseAdapter.getLeaseReponseListFromLeases(leaseList);
        return leaseResponses;
    }

    @Override
    public RevenueDTO getRevenue(String state) {
        return null;
    }

    @Override
    public LeaseDTO save(LeaseRequest leaseRequest, Integer propertyId) {
        Lease lease = LeaseAdapter.getLeaseFromRequest(leaseRequest);
        Property p = this.propertyRepository.findById(propertyId).orElse(null);
        if (p == null) return null;

        lease.setProperty(p);
        lease = this.leaseRepository.save(lease);

        LeaseDTO leaseDTO = LeaseAdapter.getLeaseDTOFromLease(lease);
        return leaseDTO;
    }
}
