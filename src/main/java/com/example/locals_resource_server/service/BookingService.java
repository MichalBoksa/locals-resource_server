package com.example.locals_resource_server.service;

import com.example.locals_resource_server.model.Booking;
import com.example.locals_resource_server.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;

    public void addNewBooking(Booking booking) {
        bookingRepository.save(booking);
    }
}
