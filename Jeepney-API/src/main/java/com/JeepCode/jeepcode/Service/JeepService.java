package com.JeepCode.jeepcode.Service;
import com.JeepCode.jeepcode.Controller.JeepRoutesController;
import com.JeepCode.jeepcode.Entity.JeepRoute;
import com.JeepCode.jeepcode.Entity.RouteWaypoint;
import com.JeepCode.jeepcode.Entity.Waypoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JeepCode.jeepcode.Repository.JeepRoutesRepo;

import java.util.ArrayList;
import java.util.List;


@Service
public class JeepService {

    @Autowired
    private JeepRoutesRepo jeepRoutesRepo;


    public List<Waypoint> findWaypointsByJeepRoutesCode(String code) {
        List<JeepRoute> jeepRoutesList = jeepRoutesRepo.checkByCode(code);

        List<Waypoint> waypoints = new ArrayList<>();
        for (JeepRoute jeepRoutes : jeepRoutesList) {
            List<RouteWaypoint> routeWaypoints = jeepRoutes.getWaypointsList();
            for (RouteWaypoint routeWaypoint : routeWaypoints) {
                waypoints.add(routeWaypoint.getWaypoint());
            }
        }
        return waypoints;
    }
}

