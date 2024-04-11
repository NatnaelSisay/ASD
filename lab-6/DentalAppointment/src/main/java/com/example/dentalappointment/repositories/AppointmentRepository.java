package com.example.dentalappointment.repositories;

import com.example.dentalappointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
