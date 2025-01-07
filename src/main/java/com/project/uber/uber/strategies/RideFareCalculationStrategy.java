package com.project.uber.uber.strategies;

import com.project.uber.uber.entities.RideRequest;
import org.springframework.stereotype.Component;

@Component
public interface RideFareCalculationStrategy {

    double calculateFare(RideRequest rideRequest);

}
