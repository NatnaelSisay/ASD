package com.example.dentalappointment.dtos.patient;

import java.time.LocalDate;

public record PatientNoAddress(
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
