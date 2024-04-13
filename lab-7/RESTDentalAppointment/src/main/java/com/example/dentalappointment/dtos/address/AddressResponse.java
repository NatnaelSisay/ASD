package com.example.dentalappointment.dtos.address;

public record AddressResponse(
        Long id,
        String street,
        String city,
        String state,
        String zipcode
) {
}
