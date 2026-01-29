package com.springboard.service.impl;

import com.springboard.dto.UserDto;
import com.springboard.repository.UserRepository;
import com.springboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserService {

    final UserRepository repository;
    final ModelMapper mapper;

    @Override
    public void registerUser(UserDto userDto) {
        repository.save(userDto);
    }

    @Override
    public void updateUser(UserDto userDto) {


    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public UserDto getUserById(Integer id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public List<UserDto> getUserByName(String name) {
        return List.of();
    }
}
