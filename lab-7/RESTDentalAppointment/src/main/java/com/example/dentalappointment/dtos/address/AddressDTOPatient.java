package com.example.dentalappointment.dtos.address;

import com.example.dentalappointment.dtos.patient.PatientNoAddress;

public record AddressDTOPatient(
        Long id,
        String street,
        String city,
        String state,
        String zipcode,
        PatientNoAddress patient
) {
}
