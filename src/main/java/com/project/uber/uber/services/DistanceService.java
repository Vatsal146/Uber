package com.project.uber.uber.services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {

    double RIDE_FARE_MULTIPLIER = 10;

    double calculateDistance(Point source, Point destination);

}
