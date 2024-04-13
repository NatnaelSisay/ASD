package com.example.dentalappointment.services.impl;

import com.example.dentalappointment.dtos.PatientDTO;
import com.example.dentalappointment.dtos.patient.PatientAdapter;
import com.example.dentalappointment.dtos.patient.PatientDTOAddress;
import com.example.dentalappointment.model.Patient;
import com.example.dentalappointment.repositories.PatientRepository;
import com.example.dentalappointment.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        Patient saved = patientRepository.save(patient);
        PatientDTO patientDTO = new PatientDTO(
                saved.getId(),
                saved.getPatientNo(), saved.getFirstName(), saved.getLastName(),
                saved.getPhoneNumber(), saved.getRole(), saved.getDateOfBirth(),
                saved.getEmail()
        );
        return saved;
    }

    @Override
    public List<PatientDTOAddress> getPatientsSortedByLastName() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDTOAddress> result = new ArrayList<>();

        for (Patient p : patients) {
            result.add(PatientAdapter.getPatientWithAddress(p));
        }

        return result;
    }

    @Override
    public PatientDTO findPatient(Long patientId) {
        return null;
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDTO update(Patient patient, Long id) {
        Patient patient1 = this.patientRepository.findById(id).orElse(null);

        return null;
    }
}
