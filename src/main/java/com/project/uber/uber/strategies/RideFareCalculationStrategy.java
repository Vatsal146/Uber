package com.project.uber.uber.strategies;

import com.project.uber.uber.dto.RideRequestDto;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDto rideRequestDto);

}
