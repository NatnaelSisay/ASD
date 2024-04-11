package com.example.dentalappointment;

import com.example.dentalappointment.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DentalAppointmentApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DentalAppointmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        add address
        var addr1 = new Address(null, "1000N", "Fairfield", "IA", "52557");
        var addr2 = new Address(null, "1001N", "Fairfield", "IA", "52557");
        var addr3 = new Address(null, "1002N", "Fairfield", "IA", "52557");

//        add Dentist
        var dentist1 = new Dentist(null, null, "Tony", "Smith", "2323",
                "Doctor", "Surgical doc", "doc@gmail.com", "doc-password"
        );
        var dentist2 = new Dentist(null, null, "Helen", "Pearson", "2323",
                "Doctor", "Surgical doc", "doc@gmail.com", "doc-password"
        );
        var dentist3 = new Dentist(null, null, "Robin", "Pal", "2323",
                "Doctor", "Surgical doc", "doc@gmail.com", "doc-password"
        );

//        add Patient
        var patient1 = new Patient(null, null, null, "P100", "Gillan",
                "White", "23333", "Patient", LocalDate.now(), "p1@gmail.com",
                "patient-password"
        );
        var patient2 = new Patient(null, null, null, "P105", "Jil",
                "Bell", "23333", "Patient", LocalDate.now(), "p1@gmail.com",
                "patient-password"
        );
        var patient3 = new Patient(null, null, null, "P108", "Ian",
                "MacKay", "23333", "Patient", LocalDate.now(), "p1@gmail.com",
                "patient-password"
        );
        var patient4 = new Patient(null, null, null, "P110", "John",
                "Walker", "23333", "Patient", LocalDate.now(), "p1@gmail.com",
                "patient-password"
        );

//        add Appointment
        var apt1 = new Appointment(null, null, null, null, LocalDate.now());
        var apt2 = new Appointment(null, null, null, null, LocalDate.now());
        var apt3 = new Appointment(null, null, null, null, LocalDate.now());

//        add Surgery
        var s1 = new Surgery(null, null, null, "S15", "Neck",
                "4344-3434-3434");
        var s2 = new Surgery(null, null, null, "S10", "Ear",
                "4344-3434-3434"
        );
        var s3 = new Surgery(null, null, null, "S13", "Ear",
                "4344-3434-3434"
        );
    }
}
