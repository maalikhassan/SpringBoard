package com.springboard.service;

import com.springboard.dto.RoomDto;

import java.util.List;

public interface RoomService {
    void addRoom(RoomDto roomDto);
    void updateRoom(RoomDto roomDto);
    void deleteRoom(Integer id);
    RoomDto searchRoomById(Integer id);
    List<RoomDto> getAllRooms();
    List<RoomDto> searchRoomByName(String name);
}
