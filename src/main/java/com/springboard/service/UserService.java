package com.springboard.service;

import com.springboard.dto.UserDto;

import java.util.List;

public interface UserService{

    void registerUser(Integer id,String name,String email,String address,String city,Integer phone);

    void updateUser(Integer id,String name,String email,String address,String city,Integer phone);

    void deleteUser(Integer id);

    public UserDto getUserById(Integer id);

    public List<UserDto> getAllUsers();

    public List<UserDto> getUserByName(String name);
}
