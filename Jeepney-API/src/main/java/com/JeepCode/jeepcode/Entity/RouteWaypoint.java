package com.JeepCode.jeepcode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
public class RouteWaypoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeWaypointId;

    @ManyToOne
    private JeepRoute jeepRoute;

    @ManyToOne
    private Waypoint waypoint;
}
