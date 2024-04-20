package com.example.dentalappointment.controllers;


import com.example.dentalappointment.dtos.patient.PatientDTOAddress;
import com.example.dentalappointment.services.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestPatientController {

    @Mock
    PatientService patientService;
    @InjectMocks
    PatientController patientController;


    @Test
    public void testPatientControllerListAllPatient() {
        List<PatientDTOAddress> patientDTOAddresses = List.of(new PatientDTOAddress(), new PatientDTOAddress());

        when(patientService.getPatientsSortedByLastName()).thenReturn(patientDTOAddresses);
//
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
        ResponseEntity<Response<PatientDTOAddress>> response = patientController.findAllPatients();
//
        assertEquals(response.getBody().data.size(), 2);
        verify(patientService, atMostOnce()).getPatientsSortedByLastName();
    }
}
