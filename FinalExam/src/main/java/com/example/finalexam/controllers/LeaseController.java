package com.example.finalexam.controllers;

import com.example.finalexam.dtos.RevenueDTO;
import com.example.finalexam.dtos.lease.LeaseDTO;
import com.example.finalexam.dtos.lease.LeaseRequest;
import com.example.finalexam.dtos.lease.LeaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leases")
public class LeaseController {

    @GetMapping
    public ResponseEntity<List<LeaseResponse>> getLeases() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/revenue/{state}")
    public ResponseEntity<RevenueDTO> getTotalRevenueByState(@PathVariable String state) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/{propertyId}")
    public ResponseEntity<LeaseDTO> save(@PathVariable Integer propertyId, @RequestBody LeaseRequest leaseRequest) {
        return ResponseEntity.ok(null);
    }
}
