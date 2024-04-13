package com.example.dentalappointment.services;

import com.example.dentalappointment.dtos.PatientDTO;
import com.example.dentalappointment.dtos.patient.PatientDTOAddress;
import com.example.dentalappointment.model.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);

    List<PatientDTOAddress> getPatientsSortedByLastName();

    PatientDTO findPatient(Long patientId);

    void deletePatient(Long id);

    PatientDTO update(Patient patient, Long id);
}
