package com.springboard.service.impl;

import com.springboard.dto.AdminDashboardDto;
import com.springboard.dto.RoomDto;
import com.springboard.entity.RoomEntity;
import com.springboard.repository.BookingRepository;
import com.springboard.repository.RoomRepository;
import com.springboard.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    final ModelMapper modelMapper;
    final RoomRepository roomRepository;
    final BookingRepository bookingRepository; // Inject the Booking Repo

    @Override
    public void addRoom(RoomDto roomDto) {
        RoomEntity roomEntity = modelMapper.map(roomDto, RoomEntity.class);
        roomRepository.save(roomEntity);
    }

    @Override
    public void updateRoom(RoomDto roomDto) {
        RoomEntity roomEntity = modelMapper.map(roomDto, RoomEntity.class);
        roomRepository.save(roomEntity);
    }

    @Override
    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }

    @Override
    public RoomDto searchRoomById(Integer id) {
        RoomEntity entity = roomRepository.findById(id).orElse(null);
        if (entity == null) return null;

        RoomDto dto = modelMapper.map(entity, RoomDto.class);
        // Live Status Check
        dto.setIsBooked(bookingRepository.isRoomOccupiedNow(id, LocalDateTime.now()));
        return dto;
    }

    @Override
    public List<RoomDto> getAllRooms() {

        List<RoomEntity> roomEntityList = roomRepository.findAll();
        LocalDateTime now = LocalDateTime.now(); // Capture time once for performance

        // Stream is cleaner here
        return roomEntityList.stream().map(roomEntity -> {
            RoomDto roomDto = modelMapper.map(roomEntity, RoomDto.class);
            // THE FIX: Calculate status on the fly
            boolean isBusy = bookingRepository.isRoomOccupiedNow(roomEntity.getId(), now);
            roomDto.setIsBooked(isBusy);
            return roomDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> searchRoomByName(String name) {
        List<RoomEntity> roomEntityList = roomRepository.findByNameContainingIgnoreCase(name);
        LocalDateTime now = LocalDateTime.now();

        return roomEntityList.stream().map(roomEntity -> {
            RoomDto roomDto = modelMapper.map(roomEntity, RoomDto.class);
            boolean isBusy = bookingRepository.isRoomOccupiedNow(roomEntity.getId(), now);
            roomDto.setIsBooked(isBusy);
            return roomDto;
        }).collect(Collectors.toList());
    }

// --- DASHBOARD STATS (REPAIRED) ---

    @Override
    public Integer getTotalRooms() {
        return Math.toIntExact(roomRepository.count());
    }

    @Override
    public Integer getActiveBooking() {
        // OLD (Broken): roomRepository.countByIsBookedTrue();
        // NEW (Correct): Ask BookingRepo how many meetings are happening NOW
        return Math.toIntExact(bookingRepository.countActiveBookings(LocalDateTime.now()));
    }

    @Override
    public Integer getAvilableRooms() {
        // Total Rooms - Active Meetings = Available Rooms
        int total = Math.toIntExact(roomRepository.count());
        int active = getActiveBooking();
        return total - active;
    }

    @Override
    public Double getOccupancy() {
        int total = getTotalRooms();
        int active = getActiveBooking();

        if (total == 0) {
            return 0.00;
        } else {
            return ((double) active / (double) total) * 100;
        }
    }
}
