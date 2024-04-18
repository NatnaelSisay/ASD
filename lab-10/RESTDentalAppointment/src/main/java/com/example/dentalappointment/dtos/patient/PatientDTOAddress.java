package com.example.dentalappointment.dtos.patient;

import com.example.dentalappointment.dtos.address.AddressResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PatientDTOAddress {
    private Long id;
    private String patientNo;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private LocalDate dateOfBirth;
    private String email;
    private AddressResponse address;

    public PatientDTOAddress(
            Long id, String patientNo, String firstName, String lastName,
            String phoneNumber, String role, LocalDate dateOfBirth, String email, AddressResponse address
    ) {
        this.id = id;
        this.patientNo = patientNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
    }
}
