package com.springboard.service.impl;

import com.springboard.dto.BookingDto;
import com.springboard.dto.RoomDto;
import com.springboard.entity.BookingEntity;
import com.springboard.repository.BookingRepository;
import com.springboard.repository.PackageRepository;
import com.springboard.repository.RoomRepository;
import com.springboard.repository.UserRepository;
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

    final UserRepository userRepository;
    final RoomRepository roomRepository;
    final PackageRepository packageRepository;
    
    @Override
    public void addBooking(BookingDto bookingDto) {// 1. Validate User Exists
        // We look for the User's "id" using the Booking's "customer_id"
        if (!userRepository.existsById(bookingDto.getCustomerId())) {
            throw new RuntimeException("Error: User ID " + bookingDto.getCustomerId() + " not found.");
        }

        // 2. Validate Room Exists
        // We look for the Room's "id" using the Booking's "room_id"
        if (!roomRepository.existsById(bookingDto.getRoomId())) {
            throw new RuntimeException("Error: Room ID " + bookingDto.getRoomId() + " not found.");
        }

        // 3. Validate Time
        if (bookingDto.getEndTime().isBefore(bookingDto.getStartTime())) {
            throw new RuntimeException("Error: End time cannot be before Start time");
        }

        // NEW: Package Validation (Optional: Only if they selected one)
        if (bookingDto.getPackageId() != null && !packageRepository.existsById(bookingDto.getPackageId())) {
            throw new RuntimeException("Error: Package ID " + bookingDto.getPackageId() + " not found.");
        }

        // 4. Validate Overlap
        boolean isOccupied = bookingRepository.existsOverlap(
                bookingDto.getRoomId(),
                bookingDto.getStartTime(),
                bookingDto.getEndTime()
        );

        if (isOccupied) {
            throw new RuntimeException("Error: Room is already booked for this time slot!");
        }

        // 5. Save
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

    @Override
    public List<BookingDto> getBookingsByUser(Integer userId) {
        // Match the corrected Repository method name
        List<BookingEntity> list = bookingRepository.findByCustomerId(userId);
        return list.stream()
                .map(e -> modelMapper.map(e, BookingDto.class))
                .toList();
    }

    public List<BookingDto> getBookingsByRoom(Integer roomId) {
        List<BookingEntity> list = bookingRepository.findByRoomId(roomId);
        return list.stream().map(e -> modelMapper.map(e, BookingDto.class)).toList();
    }
}
