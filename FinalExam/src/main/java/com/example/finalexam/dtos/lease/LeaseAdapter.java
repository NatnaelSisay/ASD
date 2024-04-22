package com.example.finalexam.dtos.lease;

import com.example.finalexam.dtos.property.PropertyAdapter;
import com.example.finalexam.dtos.property.PropertyResponse;
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

    public static Lease getLeaseFromRequest(LeaseRequest leaseRequest) {
        if (leaseRequest == null) return null;

        Lease lease = new Lease(
                leaseRequest.leaseReferenceNumber(),
                leaseRequest.startDate(),
                leaseRequest.endDate()
        );

        return lease;
    }

    public static LeaseDTO getLeaseDTOFromLease(Lease lease) {
        if(lease == null) return null;

        PropertyResponse propertyResponse = PropertyAdapter.getPropertyResponseFromProperty(lease.getProperty());
        LeaseDTO leaseDTO = new LeaseDTO(
                lease.getLeaseId(),
                lease.getLeaseReferenceNumber(),
                lease.getStartDate(),
                lease.getEndDate(),
                propertyResponse
        );

        return leaseDTO;
    }

    public static List<LeaseDTO> getLeaseReponseListFromLeases(List<Lease> leaseList) {
        if(leaseList == null) return null;

        return leaseList.stream().map(
                lease -> getLeaseDTOFromLease(lease)
        ).toList();

    }
}
