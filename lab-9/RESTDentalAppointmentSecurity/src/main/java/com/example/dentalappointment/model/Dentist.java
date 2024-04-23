package com.example.dentalappointment.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentist extends User {
    @OneToMany(
            mappedBy = "dentist",
            cascade = CascadeType.PERSIST
    )
    List<Appointment> appointments;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private String specialization;

    public Dentist(String firstName, String lastName, String phoneNumber, String role, String specialization, String email, String password) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.specialization = specialization;
    }
}
