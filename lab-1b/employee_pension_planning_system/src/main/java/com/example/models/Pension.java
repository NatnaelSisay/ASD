package com.example.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pension {
  private String planReferenceNumber;
  private LocalDate enrollmentDate;
  private BigDecimal monthlyContribution;
}
