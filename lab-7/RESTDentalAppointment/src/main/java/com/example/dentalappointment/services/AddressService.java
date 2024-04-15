package com.example.dentalappointment.services;

import com.example.dentalappointment.dtos.address.AddressDTOPatient;
import com.example.dentalappointment.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    Address addAddress(Address address);

    List<AddressDTOPatient> findAll();
}
