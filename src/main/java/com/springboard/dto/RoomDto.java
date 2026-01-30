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
    private Boolean isBooked = false;// We KEEP this, but it is not saved to DB. It is calculated on the fly.
    private Boolean isAvailable;
    private Integer package_id;
}
