package com.example.dentalappointment.dtos.address;

public record AddressRequest(
        String street,
        String city,
        String state,
        String zipcode
) {
}
