package com.example.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
  private long employeeId;
  private String firstName;
  private String lastName;
  private LocalDate employeeDate;
  private BigDecimal yearlySalary;
}
