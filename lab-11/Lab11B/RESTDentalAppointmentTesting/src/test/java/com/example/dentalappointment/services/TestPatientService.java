package com.example.dentalappointment.services;

import com.example.dentalappointment.dtos.patient.PatientAdapter;
import com.example.dentalappointment.dtos.patient.PatientDTOAddress;
import com.example.dentalappointment.exceptions.ItemNotFound;
import com.example.dentalappointment.model.Patient;
import com.example.dentalappointment.repositories.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestPatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    Patient patient = new Patient(
            "P001",
            "Natnael",
            "Kagnaw",
            "02323",
            "Patient", LocalDate.now(),
            "natyjava8@gmail.com",
            " String password"
    );

    @BeforeEach
    public void beforeEach() {
        patient = patientRepository.save(patient);
    }

    @AfterEach
    public void afterEach() {
        patientRepository.deleteById(patient.getId());
    }

    @Test
    public void testFindPatientWithValidId() throws ItemNotFound {
        PatientDTOAddress patientDTOAddress = PatientAdapter.getPatientWithAddress(patient);

        PatientDTOAddress result = patientService.findPatient(patient.getId());

        assertEquals(patientDTOAddress, result);
    }

    @Test
    public void testFindPatientWithValidInvalidId() {
        long patientId = 2L;
        String expectedMessage = String.format("Patient not found. id = %s", patientId);

        RuntimeException exception = assertThrows(ItemNotFound.class, () -> {
            patientService.findPatient(2L);
        });

        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}
