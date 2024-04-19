package com.JeepCode.jeepcode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class JeepRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    private String routeCode;

    @OneToMany(mappedBy = "jeepRoute")
    private List<RouteWaypoint> waypointsList = new ArrayList<>();
}
