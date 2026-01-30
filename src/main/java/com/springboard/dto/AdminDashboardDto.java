package com.springboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminDashboardDto {

    private Integer totalRooms;
    private Double occupancy;
    private Integer totalActiveBookings;
    private Integer available;

}
