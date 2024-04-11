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
    @ManyToOne
    Address address;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
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
}
