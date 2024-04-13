package com.example.dentalappointment.dtos.address;

import com.example.dentalappointment.model.Address;

public class AddressAdapter {
    public static AddressResponse getAddressResponse(Address address) {

        return new AddressResponse(
                address.getId(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipcode()
        );
    }
}
