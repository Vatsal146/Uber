package com.project.uber.uber.strategies;

import com.project.uber.uber.entities.Driver;
import com.project.uber.uber.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
     List<Driver> findMatchingDriver(RideRequest rideRequest);
}