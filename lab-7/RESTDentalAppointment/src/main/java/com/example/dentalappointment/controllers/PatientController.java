package com.example.dentalappointment.controllers;

import com.example.dentalappointment.dtos.patient.PatientDTOAddress;
import com.example.dentalappointment.dtos.patient.PatientRequestWithAddress;
import com.example.dentalappointment.exceptions.ItemNotFound;
import com.example.dentalappointment.services.PatientService;
import lombok.AllArgsConstructor;
import lombok.Data;
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

    @GetMapping
    public ResponseEntity<Response<PatientDTOAddress>> findAllPatients() {
        List<PatientDTOAddress> patients = patientService.getPatientsSortedByLastName();
        return ResponseEntity.ok(new Response<>(patients));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<ResponseUnique<PatientDTOAddress>> findPatient(@PathVariable Long patientId) throws ItemNotFound {
        PatientDTOAddress patient = patientService.findPatient(patientId);
        return ResponseEntity.ok(new ResponseUnique<>(patient));
    }


    @PostMapping
    public ResponseEntity<ResponseUnique<PatientDTOAddress>> savePatient(@RequestBody PatientRequestWithAddress patient) {
        PatientDTOAddress savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok(new ResponseUnique<>(savedPatient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id) {
        this.patientService.deletePatient(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUnique<PatientDTOAddress>> updatePatient(@RequestBody PatientRequestWithAddress patient, @PathVariable Long id) throws ItemNotFound {
        PatientDTOAddress patientDTO = this.patientService.update(patient, id);
        return ResponseEntity.ok(new ResponseUnique<>(patientDTO));
    }
//    search patient

    @GetMapping("/search/{searchString}")
    public ResponseEntity<Response<List<PatientDTOAddress>>> searchPatient(@PathVariable String searchString) {
        List<PatientDTOAddress> patients = this.patientService.search(searchString);
        return ResponseEntity.ok(new Response(patients));
    }
}

@Data
@AllArgsConstructor
class Response<T> {
    List<T> data;
}

@Data
@AllArgsConstructor
class ResponseUnique<T> {
    T data;
}