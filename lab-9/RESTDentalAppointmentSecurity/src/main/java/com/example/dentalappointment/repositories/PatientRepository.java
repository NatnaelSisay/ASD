package com.example.dentalappointment.repositories;

import com.example.dentalappointment.model.Patient;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends UserRepository<Patient> {
    @Query("select p from Patient p where p.firstName like %:searchString% " +
            "or p.lastName like %:searchString% " +
            "or p.patientNo like %:searchString% " +
            "or p.email like %:searchString%"
    )
    List<Patient> search(String searchString);
}
//public interface PatientRepository extends UserRepository<Patient> {
//
//}
