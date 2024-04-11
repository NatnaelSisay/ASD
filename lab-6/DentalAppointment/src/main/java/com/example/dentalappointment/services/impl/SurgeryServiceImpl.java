package com.example.dentalappointment.services.impl;

import com.example.dentalappointment.model.Surgery;
import com.example.dentalappointment.repositories.SurgeryRepository;
import com.example.dentalappointment.services.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    @Autowired
    SurgeryRepository surgeryRepository;

    @Override
    public Surgery addSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }
}
