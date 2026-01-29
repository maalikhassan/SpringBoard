package com.springboard.controller;

import com.springboard.dto.UserDto;
import com.springboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/User")
public class UserController implements UserService {

    final UserService service;

    @PostMapping("/register-user")
    public void registerUser(@RequestBody Integer id, String name, String email, String address, String city, Integer phone) {
        service.registerUser(id, name, email, address, city, phone);
    }

    @PutMapping("/update-user")
    public void updateUser(@RequestBody Integer id, String name, String email, String address, String city, Integer phone) {
        service.updateUser(id, name, email, address, city, phone);
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
    }

    @GetMapping("/get-user/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @GetMapping("/get-all-users")
    public List<UserDto> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/get-user-by-name/{name}")
    public List<UserDto> getUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }
}
