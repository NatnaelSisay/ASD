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
