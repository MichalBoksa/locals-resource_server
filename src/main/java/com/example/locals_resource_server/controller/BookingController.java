package com.example.locals_resource_server.controller;

import com.example.locals_resource_server.model.Booking;
import com.example.locals_resource_server.repository.BookingRepository;
import com.example.locals_resource_server.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    @PostMapping("/addBooking")
    public void addNewBooking(@RequestBody Booking booking) {
        bookingService.addNewBooking(booking);}
}
