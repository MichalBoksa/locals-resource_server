package com.example.locals_resource_server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private int id;
    private Date date;
    private String message;
//TODO do it better
//cuz i didn't get user and guide in response
//    @JsonBackReference(value="user-booking")
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @JsonBackReference(value="guide-booking")
//    @ManyToOne
//    @JoinColumn(name = "guide_id")
//    private Guide guide;
@Column(name = "guide_id")
    private int guideId;
@Column(name = "user_id")
    private int userId;

    @Column(name="is_accepted")
    private Boolean isAccepted;

    public Booking(Booking booking) {
        this.id = booking.id;
        this.date = booking.date;
        this.message = booking.message;
        this.guideId = booking.guideId;
        this.userId = booking.userId;
        this.isAccepted = booking.isAccepted;
    }

    public void acceptBooking() {
        setIsAccepted(true);
    }
}
