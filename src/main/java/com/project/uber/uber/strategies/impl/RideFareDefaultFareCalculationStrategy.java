package com.project.uber.uber.strategies.impl;

import com.project.uber.uber.dto.RideRequestDto;
import com.project.uber.uber.entities.RideRequest;
import com.project.uber.uber.services.DistanceService;
import com.project.uber.uber.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.project.uber.uber.services.DistanceService.RIDE_FARE_MULTIPLIER;

@Service
@RequiredArgsConstructor
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropOffLocation());

        return distance * RIDE_FARE_MULTIPLIER;
    }
}
