package com.project.uber.uber.services.impl;

import com.project.uber.uber.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistnaceServiceImpl implements DistanceService {
    @Override
    public double calculateDistance(Point source, Point destination) {
        //TODO call 3rd party API called OSRM to fetch the distance
        return 0;
    }
}
