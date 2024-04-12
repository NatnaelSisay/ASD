package com.example.dentalappointment.repositories;

import com.example.dentalappointment.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
