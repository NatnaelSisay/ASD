package com.example.dentalappointment.repositories;

import com.example.dentalappointment.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
