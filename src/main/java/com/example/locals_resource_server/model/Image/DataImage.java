package com.example.locals_resource_server.model.Image;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DataImage {
    List<DataAttributes> data;

    @JsonProperty("data")
    public List<DataAttributes> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<DataAttributes> data) {
        this.data = data;
    }
}
