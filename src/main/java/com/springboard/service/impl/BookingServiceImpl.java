package com.springboard.service.impl;

import com.springboard.dto.BookingDto;
import com.springboard.dto.RoomDto;
import com.springboard.entity.BookingEntity;
import com.springboard.repository.BookingRepository;
import com.springboard.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    final ModelMapper modelMapper;
    final BookingRepository bookingRepository;
    
    @Override
    public void addBooking(BookingDto bookingDto) {
        // 1. Validation: "Time Travel" Check
        if (bookingDto.getEndTime().isBefore(bookingDto.getStartTime())) {
            throw new RuntimeException("Error: End time cannot be before Start time");
        }

        // 2. Validation: "Double Booking" Check
        boolean isOccupied = bookingRepository.existsOverlap(
                bookingDto.getRoom_id(),      // Check this specific room
                bookingDto.getStartTime(),    // The new desired start
                bookingDto.getEndTime()       // The new desired end
        );

        if (isOccupied) {
            throw new RuntimeException("Error: Room is already booked for this time slot!");
        }

        // 3. If Safe -> Save
        BookingEntity bookingEntity = modelMapper.map(bookingDto, BookingEntity.class);
        bookingRepository.save(bookingEntity);
    }

    @Override
    public void updateBooking(BookingDto bookingDto) {
        BookingEntity bookingEntity = modelMapper.map(bookingDto, BookingEntity.class);
        bookingRepository.save(bookingEntity);
    }

    @Override
    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public BookingDto searchBookingById(Integer id) {
        return modelMapper.map(bookingRepository.findById(id), BookingDto.class); //own way
    }

    @Override
    public List<BookingDto> getAllBookings() {
        List<BookingEntity> bookingEntityList = bookingRepository.findAll();
        List<BookingDto> bookingDtoList = new ArrayList<>();

        bookingEntityList.forEach(bookingEntity ->
        {
            BookingDto bookingDto =  modelMapper.map(bookingEntity, BookingDto.class);
            bookingDtoList.add(bookingDto);
        });

        return bookingDtoList;
    }
}
