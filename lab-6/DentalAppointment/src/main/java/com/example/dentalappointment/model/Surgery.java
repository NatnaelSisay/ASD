package com.example.dentalappointment.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Surgery {
    @OneToOne
    Address address;
    @OneToMany(mappedBy = "")
    List<Appointment> appointments;

    @Id
    @GeneratedValue
    private Long id;
    private String surgeryNo;
    private String name;
    private String phoneNumber;
}
