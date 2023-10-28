package com.example.locals_resource_server.controller;

import com.example.locals_resource_server.model.Location.LocationDetails;
import com.example.locals_resource_server.model.Location.LocationSearch;
import com.example.locals_resource_server.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@AllArgsConstructor
public class LocationController {

    public static final String idk = "MediaType.APPLICATION_JSON";
private LocationService locationService;

    @GetMapping(path = "/attractions/{id_location}")
    public LocationDetails getLocationDetails(@PathVariable String id_location) {
        return locationService.getLocationDetails(id_location);
        // return locationDetailsFlux.collect(Collectors.toList()).share().block();
    }

    @GetMapping(path = "/attractions/cityAttractions/{cityName}")
    public List<LocationSearch> getCityAttractions(@PathVariable String cityName) {
        return locationService.getCityAttractions(cityName);
    }

}