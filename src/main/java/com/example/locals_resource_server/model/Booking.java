package com.example.locals_resource_server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private int id;
    private Date date;
    private String message;

    @JsonBackReference(value="guide-booking")
    @ManyToOne
    @JoinColumn(name = "guide_id")
    private Guide guide;

    @JsonBackReference(value="user-booking")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
