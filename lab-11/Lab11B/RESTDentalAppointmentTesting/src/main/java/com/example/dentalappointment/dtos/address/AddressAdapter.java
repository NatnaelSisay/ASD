package com.example.dentalappointment.dtos.address;

import com.example.dentalappointment.dtos.patient.PatientNoAddress;
import com.example.dentalappointment.model.Address;
import com.example.dentalappointment.model.Patient;

public class AddressAdapter {
    public static AddressResponse getAddressResponse(Address address) {
        if (address == null) return null;
        return new AddressResponse(
                address.getId(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipcode()
        );
    }

    public static Address getAddressFromRequest(AddressRequest a) {
        if (a == null) return null;

        return new Address(
                a.street(),
                a.city(),
                a.state(),
                a.zipcode()
        );
    }

    public static AddressDTOPatient getAddressDTOPatientFromAddress(Address address) {
        if (address == null) return null;

        Patient p = address.getPatient();
        PatientNoAddress patient = null;

        if (p != null) {
            patient = new PatientNoAddress(
                    p.getPatientNo(),
                    p.getFirstName(),
                    p.getLastName(),
                    p.getPhoneNumber(),
                    p.getRole(),
                    p.getDateOfBirth(),
                    p.getEmail()
            );
        }

        AddressDTOPatient dto = new AddressDTOPatient(
                address.getId(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipcode(),
                patient
        );

        return dto;
    }
}
