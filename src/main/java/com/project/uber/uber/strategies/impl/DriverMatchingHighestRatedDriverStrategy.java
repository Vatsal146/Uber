package com.project.uber.uber.strategies.impl;

import com.project.uber.uber.dto.RideRequestDto;
import com.project.uber.uber.entities.Driver;
import com.project.uber.uber.entities.RideRequest;
import com.project.uber.uber.repositories.DriverRepository;
import com.project.uber.uber.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }
}