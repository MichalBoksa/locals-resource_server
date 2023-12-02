package com.example.locals_resource_server.service;

import com.example.locals_resource_server.model.Booking;
import com.example.locals_resource_server.repository.BookingRepository;
import com.example.locals_resource_server.repository.UserRepository;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;
    private UserRepository userRepository;

    public void addNewBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(String email) {
       int id = userRepository.findUserByEmail(email).get().getId();
       return bookingRepository.findAllByUserId(id);
    }
}
