package com.project.uber.uber.strategies.impl;

import com.project.uber.uber.dto.RideRequestDto;
import com.project.uber.uber.strategies.RideFareCalculationStrategy;

public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
