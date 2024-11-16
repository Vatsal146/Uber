package com.project.uber.uber.services;

import org.geolatte.geom.Point;

public interface DistanceService {
    double calculateDistance(Point source, Point destination);
}
