package com.project.uber.uber.dto;

import com.project.uber.uber.entities.enums.PaymentMethod;
import com.project.uber.uber.entities.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {
    private Long id;

    private PointDto pickupLocation;

    private PointDto dropOffLocation;

    private LocalDateTime createdTime;

    private RiderDto riderDto;

    private DriverDto driverDto;

    private PaymentMethod paymentMethod;

    private RideStatus rideStatus;

    private String otp;

    private double fare;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;
}
