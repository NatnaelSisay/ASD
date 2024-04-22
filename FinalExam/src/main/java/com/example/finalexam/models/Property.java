package com.example.finalexam.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    @OneToMany(mappedBy = "property")
    public List<Lease> leases;
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(nullable = false)
    private String propertyRef;
    private String city;
    private String state;
    @NotNull
    @Column(nullable = false)
    private Double monthlyRentalRate;
}
