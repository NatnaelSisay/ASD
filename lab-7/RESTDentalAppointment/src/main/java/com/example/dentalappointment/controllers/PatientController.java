package com.example.dentalappointment.controllers;

import com.example.dentalappointment.dtos.PatientDTO;
import com.example.dentalappointment.model.Patient;
import com.example.dentalappointment.services.PatientService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patients")
public class PatientController {
    PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //    get patients
    @GetMapping
    public ResponseEntity<Patients> findAllPatients() {
        List<PatientDTO> patients = patientService.getPatientsSortedByLastName();
        return ResponseEntity.ok(new Patients(patients));
    }

    //    get patient
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDTO> findPatient(@RequestParam Long patientId) {
        PatientDTO patient = patientService.findPatient(patientId);
        return ResponseEntity.ok(patient);
    }

    //    add patient
    @PostMapping
    public ResponseEntity<PatientDTO> savePatient(@RequestBody Patient patient) {
        Patient saved = patientService.addPatient(patient);
        PatientDTO dto = new PatientDTO(
                saved.getId(),
                saved.getPatientNo(), saved.getFirstName(), saved.getLastName(),
                saved.getPhoneNumber(), saved.getRole(), saved.getDateOfBirth(),
                saved.getEmail()
        );

        return ResponseEntity.ok(dto);
    }

    //    delete patient
    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id) {
        this.patientService.deletePatient(id);
        return ResponseEntity.ok(null);
    }

    //    update patient
    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody Patient patient, @PathVariable Long id) {
        PatientDTO patientDTO = this.patientService.update(patient, id);
        return ResponseEntity.ok(patientDTO);
    }
//    search patient
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Patients {
    List<PatientDTO> patients;
}