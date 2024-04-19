package com.JeepCode.jeepcode.Controller;

import com.JeepCode.jeepcode.Entity.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.JeepCode.jeepcode.Service.JeepService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class JeepRoutesController {

    @Autowired
    private JeepService jeepService;

    @GetMapping("jeepney")
    public ResponseEntity<?> getWaypointsByCodes(@RequestParam List<String> routeCodes) {
        Map<String, List<Map<String, Object>>> routeWaypointsMap = new HashMap<>();

        for (String routeCode : routeCodes) {
            List<Waypoint> waypoints = jeepService.findWaypointsByJeepRoutesCode(routeCode);
            List<Map<String, Object>> waypointsDetails = new ArrayList<>();

            for (Waypoint waypoint : waypoints) {
                Map<String, Object> waypointDetails = new HashMap<>();
                waypointDetails.put("id", waypoint.getRouteWaypoints());
                waypointDetails.put("name", waypoint.getName());
                waypointsDetails.add(waypointDetails);
            }

            routeWaypointsMap.put(routeCode, waypointsDetails);
        }

        if (routeWaypointsMap.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(routeWaypointsMap);
        }
    }
}
