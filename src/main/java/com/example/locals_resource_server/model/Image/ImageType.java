package com.example.locals_resource_server.model.Image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageType {
private ImageAttributes medium;

    @JsonProperty("medium")
    public ImageAttributes getMedium() {
        return medium;
    }

    @JsonProperty("medium")
    public void setMedium(ImageAttributes medium) {
        this.medium = medium;
    }
}
