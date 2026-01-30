package com.springboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingDto {
    private Integer id;
    private Integer customer_id;
    private Integer company_id;
    private Integer room_id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String purpose;
    private Integer numberOfGuests;
}
