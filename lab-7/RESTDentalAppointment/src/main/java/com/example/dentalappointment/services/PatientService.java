package com.example.dentalappointment.services;

import com.example.dentalappointment.dtos.PatientDTO;
import com.example.dentalappointment.dtos.patient.PatientDTOAddress;
import com.example.dentalappointment.dtos.patient.PatientRequestWithAddress;
import com.example.dentalappointment.exceptions.ItemNotFound;
import com.example.dentalappointment.model.Patient;

import java.util.List;

public interface PatientService {
    //    PatientDTOAddress addPatient(PatientRequest patient);
    PatientDTOAddress addPatient(PatientRequestWithAddress patientRequestWithAddress);

    List<PatientDTOAddress> getPatientsSortedByLastName();

    PatientDTOAddress findPatient(Long patientId) throws ItemNotFound;

    void deletePatient(Long id);

    PatientDTOAddress update(PatientRequestWithAddress patient, Long id) throws ItemNotFound;
}
