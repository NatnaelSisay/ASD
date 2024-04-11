package com.example.dentalappointment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Appointment {
    @OneToOne
    Surgery surgery;
    @OneToOne
    Patient patient;
    @OneToOne
    Dentist dentist;

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
}
