package com.example.dentalappointment.services.impl;

import com.example.dentalappointment.model.Appointment;
import com.example.dentalappointment.repositories.AppointmentRepository;
import com.example.dentalappointment.services.AppointmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(
            AppointmentRepository appointmentRepository
    ) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return this.appointmentRepository.save(appointment);
    }
}
