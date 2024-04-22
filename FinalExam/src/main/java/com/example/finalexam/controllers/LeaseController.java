package com.example.finalexam.controllers;

import com.example.finalexam.dtos.RevenueDTO;
import com.example.finalexam.dtos.lease.LeaseDTO;
import com.example.finalexam.dtos.lease.LeaseRequest;
import com.example.finalexam.dtos.lease.LeaseResponse;
import com.example.finalexam.services.LeaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leases")
public class LeaseController {
    LeaseService leaseService;

    public LeaseController(
            LeaseService leaseService
    ) {
        this.leaseService = leaseService;
    }

    @GetMapping
    public ResponseEntity<List<LeaseResponse>> getLeases() {
        List<LeaseResponse> leaseResponses = this.leaseService.findAll();
        return ResponseEntity.ok(leaseResponses);
    }

    @GetMapping("/revenue/{state}")
    public ResponseEntity<RevenueDTO> getTotalRevenueByState(@PathVariable String state) {
        RevenueDTO revenue = this.leaseService.getRevenue(state);
        return ResponseEntity.ok(revenue);
    }

    @PostMapping("/{propertyId}")
    public ResponseEntity<LeaseDTO> save(
            @PathVariable Integer propertyId,
            @RequestBody LeaseRequest leaseRequest
    ) {
        LeaseDTO lease = this.leaseService.save(leaseRequest, propertyId);
        return ResponseEntity.ok(lease);
    }
}
