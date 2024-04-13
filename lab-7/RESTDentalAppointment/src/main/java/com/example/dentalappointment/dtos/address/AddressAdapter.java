package com.example.dentalappointment.dtos.address;

import com.example.dentalappointment.model.Address;

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
}
