package com.example.dentalappointment.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Patient {
    @OneToOne
    Address address;
    @OneToMany
    List<Appointment> appointments;
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
}
