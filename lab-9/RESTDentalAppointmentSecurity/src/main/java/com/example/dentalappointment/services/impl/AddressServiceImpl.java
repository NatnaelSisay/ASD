package com.example.dentalappointment.services.impl;

import com.example.dentalappointment.dtos.address.AddressAdapter;
import com.example.dentalappointment.dtos.address.AddressDTOPatient;
import com.example.dentalappointment.model.Address;
import com.example.dentalappointment.repositories.AddressRepository;
import com.example.dentalappointment.services.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<AddressDTOPatient> findAll() {
        System.out.println("-- Find addresses with patient");
        List<Address> addresses = this.addressRepository.findAll();

//        System.out.println(addresses);
        return addresses.stream().map(
                address -> AddressAdapter.getAddressDTOPatientFromAddress(address)
        ).toList();
    }
}
