package com.example.locals_resource_server.controller;

import com.example.locals_resource_server.model.Location.LocationDetails;
import com.example.locals_resource_server.model.Location.LocationSearch;
import com.example.locals_resource_server.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/attractions")
public class LocationController {

private LocationService locationService;

    @GetMapping(path = "/{id_location}")
    public LocationDetails getLocationDetails(@PathVariable String id_location) {
        return locationService.getLocationDetails(id_location);
    }

    @GetMapping(path = "/favoritesLocations/{locationIds}")
    public List<LocationDetails> getFavoritesListLocations(@PathVariable String locationIds) {
        return locationService.getFavoritesLocationDetails(locationIds);
    }

    @GetMapping(path = "/cityAttractions/{cityName}")
    public List<LocationDetails> getCityAttractions(@PathVariable String cityName) {
        return locationService.getCityAttractions(cityName);
    }

}
