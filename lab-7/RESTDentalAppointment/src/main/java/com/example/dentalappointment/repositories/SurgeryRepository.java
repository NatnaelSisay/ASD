package com.example.dentalappointment.repositories;

import com.example.dentalappointment.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
