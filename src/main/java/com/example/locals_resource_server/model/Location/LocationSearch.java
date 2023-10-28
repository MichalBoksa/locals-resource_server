package com.example.locals_resource_server.model.Location;

public class LocationSearch {

    private String location_id;
    private String name;
    private LocationAddress address_obj;


    public String getLocation() {
        return location_id;
    }

    public void setLocation(String location_id) {
        this.location_id = location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }


    public LocationAddress getAddress_obj() {
        return address_obj;
    }

    public void setAddress_obj(LocationAddress address_obj) {
        this.address_obj = address_obj;
    }
}
