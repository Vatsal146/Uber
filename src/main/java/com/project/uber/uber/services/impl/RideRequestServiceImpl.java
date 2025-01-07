package com.project.uber.uber.services.impl;

import com.project.uber.uber.entities.RideRequest;
import com.project.uber.uber.exceptions.ResourceNotFoundException;
import com.project.uber.uber.repositories.RideRequestRepository;
import com.project.uber.uber.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long requestId) {
        return rideRequestRepository.findById(requestId)
                .orElseThrow(()-> new ResourceNotFoundException("RideRequest not found with id: " + requestId));
    }

    @Override
    public void update(RideRequest rideRequest) {

        rideRequestRepository.findById(rideRequest.getId()).
                orElseThrow(()-> new ResourceNotFoundException("RideRequest not found with id: " + rideRequest.getId()));

        rideRequestRepository.save(rideRequest);
    }
}
