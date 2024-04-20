package com.example.dentalappointment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    private String patientNo;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private LocalDate dateOfBirth;
    private String email;
    private String password;

    public PatientDTO(Long id, String patientNo, String firstName, String lastName, String phoneNumber, String role, LocalDate dateOfBirth, String email) {
        this.id = id;
        this.patientNo = patientNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
}
