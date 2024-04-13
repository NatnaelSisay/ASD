package com.example.dentalappointment.services;

import com.example.dentalappointment.model.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Address addAddress(Address address);
}
