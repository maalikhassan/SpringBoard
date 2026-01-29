package com.springboard.service.impl;

import com.springboard.dto.UserDto;
import com.springboard.entity.UserEntity;
import com.springboard.repository.UserRepository;
import com.springboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserService {

    final UserRepository repository;
    final ModelMapper mapper;

    @Override
    public void registerUser(UserDto userDto) {
        repository.save(mapper.map(userDto, UserEntity.class));
    }

    @Override
    public void updateUser(UserDto userDto) {
        repository.save(mapper.map(userDto, UserEntity.class));
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto getUserById(Integer id) {
        UserEntity userEntity = repository.findById(id).get();
        return mapper.map(userEntity, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntities = repository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            UserDto userDto = mapper.map(userEntity, UserDto.class);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public List<UserDto> getUserByName(String name) {
        List<UserEntity> userEntities = repository.findAllByName(name);
        List<UserDto> userDtos = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            UserDto userDto = mapper.map(userEntity, UserDto.class);
            userDtos.add(userDto);
        });
        return userDtos;
    }
}
