package com.springboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyDashboardDto {

    private String totalRooms;
    private String occupancy;
    private String totalActiveBookings;
    private String available;

}
