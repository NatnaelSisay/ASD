package com.example.dentalappointment.services.impl;

import com.example.dentalappointment.model.Dentist;
import com.example.dentalappointment.repositories.DentistRepository;
import com.example.dentalappointment.repositories.UserRepository;
import com.example.dentalappointment.services.DentistService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DentistServiceImpl implements DentistService {
    DentistRepository dentistRepository;

    public DentistServiceImpl(
            DentistRepository dentistRepository
    ) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist addDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
}
