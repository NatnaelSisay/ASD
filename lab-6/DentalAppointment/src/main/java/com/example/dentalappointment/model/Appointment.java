package com.example.dentalappointment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @ManyToOne
    @JoinColumn(name = "surgery_id")
    Surgery surgery;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    Patient patient;
    @ManyToOne
    @JoinColumn(name = "dentist_id")
    Dentist dentist;

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
}
