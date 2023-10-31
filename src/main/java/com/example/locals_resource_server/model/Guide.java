package com.example.locals_resource_server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guide_id")
    private String id;

    private String name;
    private String city;
    private String price;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "about_me")
    private String aboutMe;
    @Column(name = "what_to_offer")
    private String whatToOffer;
    private String languages;
    private String activities;


}
