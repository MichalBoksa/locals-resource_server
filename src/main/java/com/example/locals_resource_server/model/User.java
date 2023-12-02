package com.example.locals_resource_server.model;

import com.example.locals_resource_server.model.Location.LocationDetails;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.sql.Blob;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Favorites> locations;

    @JsonManagedReference(value="user-booking")
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Booking> bookings;

    public User(User user) {
        this.id = user.id;
        this.email = user.email;
        this.name = user.name;
        this.phoneNumber = user.phoneNumber;
        this.locations = user.locations;
        this.bookings = user.bookings;
        this.imageUri = user.imageUri;
    }

}
