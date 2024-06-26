package com.example.dentalappointment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipcode;

    @OneToOne(mappedBy = "address")
    private Surgery surgery;

    @OneToOne(mappedBy = "address")
    private Patient patient;

    public Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
