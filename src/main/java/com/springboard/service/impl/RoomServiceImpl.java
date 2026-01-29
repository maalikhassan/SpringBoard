package com.springboard.service.impl;

import com.springboard.dto.RoomDto;
import com.springboard.entity.RoomEntity;
import com.springboard.repository.RoomRepository;
import com.springboard.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    final ModelMapper modelMapper;
    final RoomRepository roomRepository;

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
        return modelMapper.map(roomRepository.findById(id), RoomDto.class); //own way
    }

    @Override
    public List<RoomDto> getAllRooms() {

        List<RoomEntity> roomEntityList = roomRepository.findAll();
        List<RoomDto> roomDtoList = new ArrayList<>();

        roomEntityList.forEach(roomEntity ->
        {
            RoomDto roomDto =  modelMapper.map(roomEntity, RoomDto.class);
            roomDtoList.add(roomDto);
        });

        return roomDtoList;
    }

    @Override
    public List<RoomDto> searchRoomByName(String name) {
        List<RoomEntity> roomEntityList = roomRepository.findByNameContainingIgnoreCase(name);
        List<RoomDto> roomDtoList = new ArrayList<>();

        roomEntityList.forEach(roomEntity ->
        {
            RoomDto roomDto =  modelMapper.map(roomEntity, RoomDto.class);
            roomDtoList.add(roomDto);
        });

        return roomDtoList;
    }
}
