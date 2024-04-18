package com.example.dentalappointment.dtos.patient;

import com.example.dentalappointment.dtos.address.AddressRequest;

import java.time.LocalDate;

public record PatientRequestWithAddress(
        String patientNo,
        String firstName,
        String lastName,
        String phoneNumber,
        String role,
        LocalDate dateOfBirth,
        String email,
        String password,
        AddressRequest address
) {
}
