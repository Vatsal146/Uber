package com.project.uber.uber.strategies.impl;

import com.project.uber.uber.entities.RideRequest;
import com.project.uber.uber.strategies.RideFareCalculationStrategy;

public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
