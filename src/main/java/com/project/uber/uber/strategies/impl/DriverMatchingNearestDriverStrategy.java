package com.project.uber.uber.strategies.impl;

import com.project.uber.uber.dto.RideRequestDto;
import com.project.uber.uber.entities.Driver;
import com.project.uber.uber.strategies.DriverMatchingStrategy;

import java.util.List;

public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    @Override
    public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
