package com.springboard.controller;

import com.springboard.dto.BookingDto;
import com.springboard.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController{

    final BookingService bookingService;

    @PostMapping("/add")
    public void addBooking(@RequestBody BookingDto bookingDto) {
        bookingService.addBooking(bookingDto);
    }

    @PutMapping("/update")
    public void updateBooking(@RequestBody BookingDto bookingDto) {
        bookingService.updateBooking(bookingDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/search/{id}")
    public BookingDto searchBookingById(@PathVariable Integer id) {
        return bookingService.searchBookingById(id);
    }

    @GetMapping("get-all")
    public List<BookingDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/user/{id}")
    public List<BookingDto> getBookingsByUser(@PathVariable Integer id) {
        return bookingService.getBookingsByUser(id);
    }

    @GetMapping("/room/{id}")
    public List<BookingDto> getBookingsByRoom(@PathVariable Integer id) {
        return bookingService.getBookingsByRoom(id);
    }
}
