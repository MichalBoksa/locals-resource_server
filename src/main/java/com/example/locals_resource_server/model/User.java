package com.example.locals_resource_server.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "resource_server_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    private String email;
    private String name;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="image_uri")
    private String imageUri;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private List<Favorites> locations;

    @Column(name="is_guide")
    private boolean isGuide;

    public User(User user) {
        this.id = user.id;
        this.email = user.email;
        this.name = user.name;
        this.phoneNumber = user.phoneNumber;
       // this.locations = user.locations;
//        this.bookings = user.bookings;
        this.imageUri = user.imageUri;
        this.isGuide = user.isGuide;
    }

}
