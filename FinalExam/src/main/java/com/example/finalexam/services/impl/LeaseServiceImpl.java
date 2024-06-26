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

import java.time.Period;
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

        leaseResponses = leaseResponses.stream().sorted(
                (a, b) -> {
                    var diff = a.leaseReferenceNumber().compareTo(b.leaseReferenceNumber());
                    if (diff == 0) return 0;
                    if (diff < 0) return 1;
                    return -1;
                }
        ).toList();

        return leaseResponses;
    }

    @Override
    public RevenueDTO getRevenue(String state) {
        List<Lease> leaseList = this.leaseRepository.findByPropertyState(state);
        Double total = 0.0;

        for (Lease lease : leaseList) {
            var diffMonths = Period.between(lease.getStartDate(), lease.getEndDate()).getMonths();
            Double price = diffMonths * lease.getProperty().getMonthlyRentalRate();
            total += price;
        }

        RevenueDTO revenueDTO = new RevenueDTO(
                state,
                total
        );

        return revenueDTO;
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
