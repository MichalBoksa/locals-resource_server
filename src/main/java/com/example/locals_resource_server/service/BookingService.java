package com.example.locals_resource_server.service;

import com.example.locals_resource_server.model.Booking;
import com.example.locals_resource_server.repository.BookingRepository;
import com.example.locals_resource_server.repository.UserRepository;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
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
        var user = userRepository.findUserByEmail(email);
        if(user != null && !user.isEmpty()){
            int id = user.get().getId();
            return bookingRepository.findAllByUserId(id);
        }
        else {
            return Collections.emptyList();
        }
    }

    public void acceptBooking(int id) {
        var booking = bookingRepository.findBookingById(id);
       Booking bookingAccepted = booking.map(Booking::new)
                .orElseThrow(() -> new RuntimeException("Runtime exception"));
       bookingAccepted.acceptBooking();
       bookingRepository.save(bookingAccepted);
    }
}
