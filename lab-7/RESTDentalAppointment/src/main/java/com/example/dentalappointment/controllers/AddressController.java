package com.example.dentalappointment.controllers;

import com.example.dentalappointment.dtos.address.AddressDTOPatient;
import com.example.dentalappointment.dtos.address.AddressResponse;
import com.example.dentalappointment.services.AddressService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/addresses")
public class AddressController {
    AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<AddressResponseList<AddressDTOPatient>> getAddresses() {
        List<AddressDTOPatient> addressDTOPatients = this.addressService.findAll();
        return ResponseEntity.ok(new AddressResponseList(addressDTOPatients));
    }
}

@Data
@AllArgsConstructor
class AddressResponseList<T> {
    List<T> data;
}

@Data
@AllArgsConstructor
class AddressResponseUnique<T> {
    T data;
}