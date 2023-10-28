package com.example.locals_resource_server.model.Image;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataAttributes {


    private Integer id;
    private Boolean isBlessed;
    private String caption;
    private String publishedDate;
    ImageType images;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getBlessed() {
        return isBlessed;
    }

    public void setBlessed(Boolean blessed) {
        isBlessed = blessed;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @JsonProperty("images")
    public ImageType getImages() {
        return images;
    }
    @JsonProperty("images")
    public void setImages(ImageType images) {
        this.images = images;
    }
}
