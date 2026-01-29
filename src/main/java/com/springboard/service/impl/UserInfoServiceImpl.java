package com.springboard.service.impl;

import com.springboard.dto.UserDto;
import com.springboard.service.UserService;

import java.util.List;

public class UserInfoServiceImpl implements UserService {


    @Override
    public void registerUser(Integer id, String name, String email, String address, String city, Integer phone) {

    }

    @Override
    public void updateUser(Integer id, String name, String email, String address, String city, Integer phone) {

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
