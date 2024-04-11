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
public class Patient {
    @OneToOne
    @JoinColumn(name = "address_id")
    Address address;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.PERSIST
    )
    List<Appointment> appointments;

    @Id
    @GeneratedValue
    private Long id;
    private String patientNo;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private LocalDate dateOfBirth;
    private String email;
    private String password;

    public Patient(String patientNo, String firstName, String lastName, String phoneNumber, String role, LocalDate dateOfBirth, String email, String password) {
        this.patientNo = patientNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
    }
}
