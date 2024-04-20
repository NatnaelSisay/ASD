package com.example.dentalappointment.repositories;

import com.example.dentalappointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("select p from Patient p where p.firstName like %:searchString% " +
            "or p.lastName like %:searchString% " +
            "or p.patientNo like %:searchString% " +
            "or p.email like %:searchString%"
    )
    List<Patient> search(String searchString);
}
