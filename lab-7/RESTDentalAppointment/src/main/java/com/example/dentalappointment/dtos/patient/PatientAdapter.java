package com.example.dentalappointment.dtos.patient;

import com.example.dentalappointment.dtos.address.AddressAdapter;
import com.example.dentalappointment.dtos.address.AddressResponse;
import com.example.dentalappointment.model.Patient;

import java.util.List;

public class PatientAdapter {
    public static PatientDTOAddress getPatientWithAddress(Patient patient) {
        if (patient == null) return null;

        AddressResponse addressResponse = AddressAdapter.getAddressResponse(patient.getAddress());
        return new PatientDTOAddress(
                patient.getId(),
                patient.getPatientNo(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getPhoneNumber(),
                patient.getRole(),
                patient.getDateOfBirth(),
                patient.getEmail(),
                addressResponse
        );
    }

    public static List<PatientDTOAddress> getPatientDTOAddressList(List<Patient> patients) {
        return patients.stream().map(
                patient -> getPatientWithAddress(patient)
        ).toList();
    }
}
