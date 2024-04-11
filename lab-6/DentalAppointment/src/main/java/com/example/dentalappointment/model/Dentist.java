package com.example.dentalappointment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Dentist {
    @OneToMany
    List<Appointment> appointments;

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private String specialization;
    private String email;
    private String password;
}
