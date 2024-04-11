package com.example.dentalappointment.services.impl;

import com.example.dentalappointment.model.Address;
import com.example.dentalappointment.repositories.AddressRepository;
import com.example.dentalappointment.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }
}
