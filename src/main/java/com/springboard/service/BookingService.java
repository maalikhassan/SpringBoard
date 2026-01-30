package com.springboard.service;

import com.springboard.dto.BookingDto;
import java.util.List;

public interface BookingService {
    void addBooking(BookingDto bookingDto);
    void updateBooking(BookingDto bookingDto);
    void deleteBooking(Integer id);
    BookingDto searchBookingById(Integer id);
    List<BookingDto> getAllBookings();
    List<BookingDto> getBookingsByUser(Integer userId);
    List<BookingDto> getBookingsByRoom(Integer roomId);
}
