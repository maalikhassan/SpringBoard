package com.springboard.service.impl;

import com.springboard.dto.AdminDashboardDto;
import com.springboard.service.AdminDashboardService;
import com.springboard.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminDashboardServiceImpl implements AdminDashboardService {

    final RoomService roomService;

    @Override
    public AdminDashboardDto getDetails() {
        AdminDashboardDto adminDashboardDto = new AdminDashboardDto();
        adminDashboardDto.setTotalRooms(roomService.getTotalRooms());
        adminDashboardDto.setAvailable(roomService.getAvilableRooms());
        adminDashboardDto.setOccupancy(roomService.getOccupancy());
        adminDashboardDto.setTotalActiveBookings(roomService.getActiveBooking());
        return adminDashboardDto;
    }
}
