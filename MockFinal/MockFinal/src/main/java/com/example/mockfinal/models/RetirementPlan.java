package com.example.mockfinal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetirementPlan {
    @OneToOne(mappedBy = "retirementPlan")
    Employee employee;
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;
    @NotNull
    @Column(unique = true, nullable = false)
    private String referenceNumber;
    @NotNull
    @Column(nullable = false)
    private LocalDate enrollmentDate;
    @NotNull
    @Column(nullable = false)
    private LocalDate retirementDate;
    private Double monthlyContribution;

    public RetirementPlan(String referenceNumber, LocalDate enrollmentDate, LocalDate retirementDate) {
        this.referenceNumber = referenceNumber;
        this.retirementDate = retirementDate;
        this.enrollmentDate = enrollmentDate;
    }
}
