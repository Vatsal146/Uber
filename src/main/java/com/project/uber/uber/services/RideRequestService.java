package com.project.uber.uber.services;

import com.project.uber.uber.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long requestId);

    void update(RideRequest rideRequest);
}
