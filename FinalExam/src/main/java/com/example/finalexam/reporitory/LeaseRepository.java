package com.example.finalexam.reporitory;

import com.example.finalexam.models.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseRepository extends JpaRepository<Lease, Long> {
}
