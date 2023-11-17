package com.example.locals_resource_server.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name="guides")
@AllArgsConstructor
@NoArgsConstructor
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guide")
    private int id;
    private String name;
    private String city;
    private int price;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "about_me")
    private String aboutMe;
    @Column(name = "what_to_offer")
    private String whatToOffer;
    private String languages;
    @Column(name = "image_url")
    private String imageURL;
    private String activities;

    @JsonManagedReference(value="guide-booking")
    @OneToMany(mappedBy = "guide", fetch = FetchType.EAGER)
    private List<Booking> bookings;

    public Guide(Guide guide) {
        this.id = guide.getId();
        this.name = guide.getName();
        this.city = guide.getCity();
        this.price = guide.getPrice();
        this.phoneNumber = guide.getPhoneNumber();
        this.aboutMe = guide.aboutMe;
        this.whatToOffer = guide.whatToOffer;
        this.languages = guide.languages;
        this.imageURL = guide.imageURL;
        this.activities = guide.getActivities();
    }
    public Guide(int id) {
        this.id = id;
    }
}
