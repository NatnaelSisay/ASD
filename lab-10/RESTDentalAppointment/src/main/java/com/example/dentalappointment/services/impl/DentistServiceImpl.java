package com.example.dentalappointment.services.impl;

import com.example.dentalappointment.model.Dentist;
import com.example.dentalappointment.repositories.DentistRepository;
import com.example.dentalappointment.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DentistServiceImpl implements DentistService {
    @Autowired
    DentistRepository dentistRepository;

    @Override
    public Dentist addDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
}
