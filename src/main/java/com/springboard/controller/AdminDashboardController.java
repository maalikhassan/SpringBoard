package com.springboard.controller;

import com.springboard.dto.AdminDashboardDto;
import com.springboard.service.AdminDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Admin")
public class AdminDashboardController {

    final AdminDashboardService service;

    @GetMapping("/get-dashboard-overview")
    public AdminDashboardDto getDetails(){
        return service.getDetails();
    }
}
