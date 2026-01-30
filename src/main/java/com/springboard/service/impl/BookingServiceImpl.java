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
