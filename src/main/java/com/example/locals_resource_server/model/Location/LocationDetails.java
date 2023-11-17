package com.example.locals_resource_server.model.Location;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LocationDetails {

    private String location_id;
    private String name;
    private String description;
    private String web_url;
    private LocationAddress address_obj;
    private Double rating;
    private List<String> imagesURLList;
    private Integer num_reviews;

}
