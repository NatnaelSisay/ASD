package com.example.mockfinal.services.impl;

import com.example.mockfinal.dtos.retirement.RetirementAdapter;
import com.example.mockfinal.dtos.retirement.RetirementDTO;
import com.example.mockfinal.models.RetirementPlan;
import com.example.mockfinal.repositories.RetirementPlanRepository;
import com.example.mockfinal.services.RetirementService;
import org.springframework.stereotype.Service;

@Service
public class RetirementServiceImpl implements RetirementService {
    RetirementPlanRepository repository;

    public RetirementServiceImpl(
            RetirementPlanRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public RetirementDTO getRetirement(Long id) {
        RetirementPlan plan = this.repository.findById(id).orElse(null);
        return RetirementAdapter.getRetirementDTOFromRetirement(plan);
    }
}
