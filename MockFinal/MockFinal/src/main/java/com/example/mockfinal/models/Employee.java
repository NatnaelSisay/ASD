package com.example.mockfinal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @OneToOne
    @JoinColumn(name = "plan_id")
    RetirementPlan retirementPlan;
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotNull
    @Column(nullable = false)
    private String firstName;
    @NotNull
    @Column(nullable = false)
    private String lastName;
    private Double yearlySalary;

    public Employee(String firstName, String lastName, Double yearlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearlySalary = yearlySalary;
    }
}
