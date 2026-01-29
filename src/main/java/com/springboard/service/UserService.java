package com.springboard.service;

import com.springboard.dto.UserDto;

import java.util.List;

public interface UserService{

    void registerUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUser(Integer id);

    public UserDto getUserById(Integer id);

    public List<UserDto> getAllUsers();

    public List<UserDto> getUserByName(String name);
}
