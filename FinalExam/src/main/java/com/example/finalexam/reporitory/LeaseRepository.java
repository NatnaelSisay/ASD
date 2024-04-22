package com.example.finalexam.reporitory;

import com.example.finalexam.models.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaseRepository extends JpaRepository<Lease, Long> {

    List<Lease> findByPropertyState(String state);
}
