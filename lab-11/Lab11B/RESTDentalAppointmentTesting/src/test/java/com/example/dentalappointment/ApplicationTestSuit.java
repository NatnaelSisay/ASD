package com.example.dentalappointment;


import com.example.dentalappointment.services.TestPatientService;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({
        TestPatientService.class,
        DentalAppointmentApplicationTests.class
})
@Suite
public class ApplicationTestSuit {
}
