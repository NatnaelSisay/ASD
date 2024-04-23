package com.example.dentalappointment.dtos.patient;

import java.time.LocalDate;

public record PatientRequest(
        String patientNo,
        String firstName,
        String lastName,
        String phoneNumber,
        String role,
        LocalDate dateOfBirth,
        String email,
        String password
) {
}
