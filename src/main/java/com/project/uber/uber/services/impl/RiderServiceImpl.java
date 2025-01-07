package com.project.uber.uber.services.impl;

import com.project.uber.uber.dto.DriverDto;
import com.project.uber.uber.dto.RideDto;
import com.project.uber.uber.dto.RideRequestDto;
import com.project.uber.uber.dto.RiderDto;
import com.project.uber.uber.entities.Driver;
import com.project.uber.uber.entities.RideRequest;
import com.project.uber.uber.entities.Rider;
import com.project.uber.uber.entities.User;
import com.project.uber.uber.entities.enums.RideRequestStatus;
import com.project.uber.uber.exceptions.ResourceNotFoundException;
import com.project.uber.uber.repositories.RideRequestRepository;
import com.project.uber.uber.repositories.RiderRepository;
import com.project.uber.uber.services.RiderService;
import com.project.uber.uber.strategies.DriverMatchingStrategy;
import com.project.uber.uber.strategies.RideFareCalculationStrategy;
import com.project.uber.uber.strategies.RideStrategyManger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideStrategyManger rideStrategyManger;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider = getCurrentRider();

        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);

        Double fare = rideStrategyManger.ridefareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);
        List<Driver> drivers = rideStrategyManger.
                driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);

        // TODO: Send notification to all driver about this ride request

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Double rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }

    @Override
    public Rider createRider(User user) {
        Rider rider = Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        // TODO: implement spring security

        return riderRepository.findById(1L).orElseThrow(()-> new ResourceNotFoundException(
                "Rider not found with id:" + 1));
    }
}
