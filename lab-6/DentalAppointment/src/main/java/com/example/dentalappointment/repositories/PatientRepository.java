package com.example.dentalappointment.repositories;

import com.example.dentalappointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
