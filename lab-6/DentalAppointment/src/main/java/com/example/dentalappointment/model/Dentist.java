package com.example.dentalappointment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentist {
    @OneToMany(
            mappedBy = "dentist",
            cascade = CascadeType.PERSIST
    )
    List<Appointment> appointments;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private String specialization;
    private String email;
    private String password;

    public Dentist(String firstName, String lastName, String phoneNumber, String role, String specialization, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.specialization = specialization;
        this.email = email;
        this.password = password;
    }
}
