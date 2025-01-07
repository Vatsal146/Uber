package com.project.uber.uber.strategies;

import com.project.uber.uber.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.project.uber.uber.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.project.uber.uber.strategies.impl.RideFareDefaultFareCalculationStrategy;
import com.project.uber.uber.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManger {

    public final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    public final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    public final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    public final RideFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating) {
        if (riderRating >= 4.8) {
            return highestRatedDriverStrategy;
        } else {
            return nearestDriverStrategy;
        }

    }

    public RideFareCalculationStrategy ridefareCalculationStrategy() {
        LocalTime surgeStartTime = LocalTime.of(18, 0);
        LocalTime surgeEndTime = LocalTime.of(21, 0);
        LocalTime currentTIme = LocalTime.now();

        boolean isSurgeTime = currentTIme.isAfter(surgeStartTime) && currentTIme.isBefore(surgeEndTime);
        if (isSurgeTime) {
            return surgePricingFareCalculationStrategy;
        } else {
            return defaultFareCalculationStrategy;
        }
    }
}
