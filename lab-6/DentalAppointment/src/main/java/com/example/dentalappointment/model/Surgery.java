package com.example.dentalappointment.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Surgery {
    @OneToOne
    Address address;
    @OneToMany
    List<Appointment> appointments;

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String phoneNumber;
}
