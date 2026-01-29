package com.springboard.controller;

import com.springboard.dto.UserDto;
import com.springboard.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements UserService {

    @PostMapping("/register-user")
    public void registerUser(@RequestBody Integer id, String name, String email, String address, String city, Integer phone) {

    }

    @PutMapping("/update-user")
    public void updateUser(@RequestBody Integer id, String name, String email, String address, String city, Integer phone) {

    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable Integer id) {

    }

    @GetMapping("/get-user/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return null;
    }

    @GetMapping("/get-all-users")
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @GetMapping("/get-user-by-name/{name}")
    public List<UserDto> getUserByName(@PathVariable String name) {
        return List.of();
    }
}
