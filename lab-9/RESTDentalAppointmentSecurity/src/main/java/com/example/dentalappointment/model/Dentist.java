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
    @OneToMany(mappedBy = "dentist", cascade = CascadeType.PERSIST)
    List<Appointment> appointments;

    private String specialization;

    public Dentist(String firstName, String lastName, String phoneNumber, String role, String specialization, String email, String password) {
        super(email, password, firstName, lastName, phoneNumber, role);
        this.specialization = specialization;
    }
}
