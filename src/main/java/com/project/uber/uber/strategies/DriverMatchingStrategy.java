package com.project.uber.uber.strategies;

import com.project.uber.uber.dto.RideRequestDto;
import com.project.uber.uber.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {

     List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
