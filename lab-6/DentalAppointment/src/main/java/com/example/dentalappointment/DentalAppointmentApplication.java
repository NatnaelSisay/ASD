package com.example.dentalappointment;

import com.example.dentalappointment.model.*;
import com.example.dentalappointment.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DentalAppointmentApplication implements CommandLineRunner {
    @Autowired
    AddressService addressService;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    DentistService dentistService;
    @Autowired
    PatientService patientService;
    @Autowired
    SurgeryService surgeryService;

    public static void main(String[] args) {
        SpringApplication.run(DentalAppointmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        add address
        var addr1 = new Address("1000N", "Fairfield", "IA", "52557");
        var addr2 = new Address("1001N", "Fairfield", "IA", "52557");
        var addr3 = new Address("1002N", "Fairfield", "IA", "52557");

//        add Dentist
        var dentist1 = new Dentist("Tony", "Smith", "2323", "Doctor",
                "Surgical doc", "doc@gmail.com", "doc-password");
        var dentist2 = new Dentist("Helen", "Pearson", "2323",
                "Doctor", "Surgical doc", "doc@gmail.com", "doc-password");
        var dentist3 = new Dentist(null, null, "Robin", "Pal", "2323",
                "Doctor", "Surgical doc", "doc@gmail.com", "doc-password");

//        add Patient
        var patient1 = new Patient("P100", "Gillan", "White", "23333",
                "Patient", LocalDate.now(), "p1@gmail.com", "patient-password");
        var patient2 = new Patient("P105", "Jil", "Bell", "23333",
                "Patient", LocalDate.now(), "p1@gmail.com", "patient-password");
        var patient3 = new Patient("P108", "Ian", "MacKay", "23333",
                "Patient", LocalDate.now(), "p1@gmail.com", "patient-password");
        var patient4 = new Patient("P110", "John", "Walker", "23333",
                "Patient", LocalDate.now(), "p1@gmail.com", "patient-password");

//        add Appointment
        var apt1 = new Appointment(LocalDate.now());
        var apt2 = new Appointment(LocalDate.now());
        var apt3 = new Appointment(LocalDate.now());

//        add Surgery
        var s1 = new Surgery("S15", "Neck", "4344-3434-3434");
        var s2 = new Surgery("S10", "Ear", "4344-3434-3434");
        var s3 = new Surgery("S13", "Ear", "4344-3434-3434");

//        construct
        dentist1 = dentistService.addDentist(dentist1);
        patient1 = patientService.addPatient(patient1);
        s1 = surgeryService.addSurgery(s1);
        apt1.setDentist(dentist1);
        apt1.setPatient(patient1);
        apt1.setSurgery(s1);

        dentist2 = dentistService.addDentist(dentist2);
        patient2 = patientService.addPatient(patient2);
        s2 = surgeryService.addSurgery(s2);
        apt2.setDentist(dentist2);
        apt2.setPatient(patient2);
        apt2.setSurgery(s2);
//
        appointmentService.addAppointment(apt1);
        appointmentService.addAppointment(apt2);
    }
}
