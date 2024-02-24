package com.example.locals_resource_server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorites_id")
    private int id;
    private String name;
    @Column(name = "place_ids")
    private String placeIds;
    @Column(name = "image_url")
    private String listImageUrl;
    @Column(name = "date_start")
    private Date startDate;
    @Column(name = "date_end")
    private Date endDate;
    @Column(name="user_id")
    private int userId;

}
