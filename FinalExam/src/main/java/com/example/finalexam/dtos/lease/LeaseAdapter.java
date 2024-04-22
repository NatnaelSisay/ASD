package com.example.finalexam.dtos.lease;

import com.example.finalexam.models.Lease;

import java.util.List;

public class LeaseAdapter {

    public static List<LeaseResponse> getLeasesResponseFromLease(List<Lease> leases) {
        if (leases == null) return null;

        return leases.stream()
                .map(lease -> getLeaseResponseFromLease(lease))
                .toList();
    }

    public static LeaseResponse getLeaseResponseFromLease(Lease lease) {
        if (lease == null) return null;

        LeaseResponse response = new LeaseResponse(
                lease.getLeaseId(),
                lease.getLeaseReferenceNumber(),
                lease.getStartDate(),
                lease.getEndDate()
        );
        return response;
    }
}
