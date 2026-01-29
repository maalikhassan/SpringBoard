package com.springboard.controller;

import com.springboard.dto.RoomDto;
import com.springboard.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@CrossOrigin
@RequiredArgsConstructor
public class RoomController{

    final RoomService roomService;

    @PostMapping("/add")
    public void addRoom(@RequestBody RoomDto roomDto) {
        roomService.addRoom(roomDto);
    }

    @PutMapping("/update")
    public void updateRoom(@RequestBody RoomDto roomDto) {
        roomService.updateRoom(roomDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
    }

    @GetMapping("/search/{id}")
    public RoomDto searchRoomById(@PathVariable Integer id) {
        return roomService.searchRoomById(id);
    }

    @GetMapping("/search-name/{name}")
    public List<RoomDto> searchRoomByName(@PathVariable String name) {
        return roomService.searchRoomByName(name);
    }

    @GetMapping("get-all")
    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms();
    }
}
