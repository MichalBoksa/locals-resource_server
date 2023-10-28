package com.example.locals_resource_server.model.Image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    List<ImageAttributes> medium;

    public List<ImageAttributes> getMedium() {
        return medium;
    }

    public void setMedium(List<ImageAttributes> medium) {
        this.medium = medium;
    }
}
