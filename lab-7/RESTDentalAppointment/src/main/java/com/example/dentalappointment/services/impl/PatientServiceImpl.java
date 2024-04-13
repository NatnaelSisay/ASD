package com.example.dentalappointment.services.impl;

import com.example.dentalappointment.dtos.PatientDTO;
import com.example.dentalappointment.dtos.patient.PatientAdapter;
import com.example.dentalappointment.dtos.patient.PatientDTOAddress;
import com.example.dentalappointment.dtos.patient.PatientRequest;
import com.example.dentalappointment.exceptions.ItemNotFound;
import com.example.dentalappointment.model.Patient;
import com.example.dentalappointment.repositories.PatientRepository;
import com.example.dentalappointment.services.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public PatientDTOAddress addPatient(PatientRequest patient) {
        Patient p = new Patient(
                patient.patientNo(),
                patient.firstName(),
                patient.lastName(),
                patient.phoneNumber(),
                patient.role(),
                patient.dateOfBirth(),
                patient.email(),
                patient.password()
        );

        p = patientRepository.save(p);

        return PatientAdapter.getPatientWithAddress(p);
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
    public PatientDTOAddress findPatient(Long patientId) throws ItemNotFound {
        Optional<Patient> findPatient = patientRepository.findById(patientId);

        if (findPatient.isPresent()) {
            Patient patient = findPatient.get();
            return PatientAdapter.getPatientWithAddress(patient);
        }

        throw new ItemNotFound(String.format("Patient not found. id = %s", patientId));
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
