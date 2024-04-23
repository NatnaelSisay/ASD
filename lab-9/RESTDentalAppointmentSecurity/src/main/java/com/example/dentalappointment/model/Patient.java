package com.example.dentalappointment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends User {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    List<Appointment> appointments;

    private String patientNo;

    private LocalDate dateOfBirth;

    public Patient(String patientNo, String firstName, String lastName, String phoneNumber, String role, LocalDate dateOfBirth, String email, String password) {
        super(email, password, firstName, lastName, phoneNumber, role);
        this.patientNo = patientNo;
        this.dateOfBirth = dateOfBirth;
    }
}
