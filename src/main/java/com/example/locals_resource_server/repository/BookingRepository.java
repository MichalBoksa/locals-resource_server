package com.example.locals_resource_server.repository;

import com.example.locals_resource_server.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

    Optional<Booking> findBookingById(int id);
    List<Booking> findAllByUserId(int id);
    List<Booking> findAllByGuideId(int id);

}
