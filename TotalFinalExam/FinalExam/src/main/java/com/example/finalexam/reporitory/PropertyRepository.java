package com.example.finalexam.reporitory;

import com.example.finalexam.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

    List<Property> findByState(String state);
}
