package com.project.uber.uber.dto;

import com.project.uber.uber.entities.Rider;
import com.project.uber.uber.entities.enums.PaymentMethod;
import com.project.uber.uber.entities.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDto pickupLocation;

    private PointDto dropOffLocation;

    private PaymentMethod paymentMethod;

    private LocalDateTime requestedTime;

    private Rider rider;

    private Double fare;

    private RideRequestStatus rideRequestStatus;

}
