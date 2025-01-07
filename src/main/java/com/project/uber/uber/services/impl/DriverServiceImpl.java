package com.project.uber.uber.services.impl;

import com.project.uber.uber.dto.DriverDto;
import com.project.uber.uber.dto.RideDto;
import com.project.uber.uber.dto.RiderDto;
import com.project.uber.uber.entities.Driver;
import com.project.uber.uber.entities.Ride;
import com.project.uber.uber.entities.RideRequest;
import com.project.uber.uber.entities.enums.RideRequestStatus;
import com.project.uber.uber.entities.enums.RideStatus;
import com.project.uber.uber.exceptions.ResourceNotFoundException;
import com.project.uber.uber.repositories.DriverRepository;
import com.project.uber.uber.services.DriverService;
import com.project.uber.uber.services.RideRequestService;
import com.project.uber.uber.services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final RideRequestService rideRequestService;

    private final DriverRepository driverRepository;

    private final RideService rideService;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public RideDto acceptRide(Long rideId) {
        RideRequest rideRequest = rideRequestService.findRideRequestById(rideId);

        if (!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)) {
            throw new RuntimeException("RideRequest cannot be accepted, status is " + rideRequest.getRideRequestStatus());
        }

        Driver currentDriver = getCurrentDriver();

        if (!currentDriver.getAvailable()) {
            throw new RuntimeException("Driver cannot be assigned due to unavailibility");
        }

        currentDriver.setAvailable(false);

        Ride ride = rideService.createNewRide(rideRequest, currentDriver);
        return modelMapper.map(ride, RideDto.class);

    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto startRide(Long rideId, String otp) {
        Ride ride = rideService.getRideById(rideId);
        Driver driver = getCurrentDriver();

        if (!driver.equals(ride.getDriver())) {
            throw new RuntimeException("Driver cannot start a ride as he has not accepted it earlier");
        }

        if (!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
            throw new RuntimeException("Ride Status is not confirmed hence cannot be started, Status: " + ride.getRideStatus());
        }

        if (!otp.equals(ride.getOtp())) {
            throw new RuntimeException("Otp is now valid, otp:" + otp);
        }

        ride.setStartedAt(LocalDateTime.now());

        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);

        return modelMapper.map(savedRide, RideDto.class);
    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto rateRider(Long rideId, Double rating) {
        return null;
    }

    @Override
    public DriverDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }

    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException("Driver not found with the ID " + 2));
    }
}
