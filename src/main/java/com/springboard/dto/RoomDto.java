package com.springboard.dto;

import com.springboard.util.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomDto {
    private Integer id;
    private String name;
    private Integer company_id;
    private RoomType type;
    private Integer capacity;
    // "Is it busy RIGHT NOW?" (Calculated on the fly from booking table and logic and shown!)
    private Boolean isBooked;
    private Boolean isAvailable;
}
