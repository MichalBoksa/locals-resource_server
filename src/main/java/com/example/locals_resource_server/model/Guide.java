package com.example.locals_resource_server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    private String email;

//    @JsonManagedReference(value="guide-booking")
//    @OneToMany(mappedBy = "guide", fetch = FetchType.LAZY)
//    private List<Booking> bookings;

    public Guide(Guide guide) {
        this.id = guide.id;
        this.name = guide.name;
        this.city = guide.city;
        this.price = guide.price;
        this.phoneNumber = guide.phoneNumber;
        this.aboutMe = guide.aboutMe;
        this.whatToOffer = guide.whatToOffer;
        this.languages = guide.languages;
        this.imageURL = guide.imageURL;
        this.activities = guide.activities;
        this.email = guide.email;
//        this.bookings = guide.bookings;
    }
    public Guide(int id) {
        this.id = id;
    }

}
