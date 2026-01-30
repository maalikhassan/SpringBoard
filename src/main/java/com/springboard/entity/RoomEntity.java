package com.springboard.entity;

import com.springboard.util.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "rooms")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer company_id;
    private RoomType type;
    private Integer capacity;
    private Boolean isBooked = true;
    private Boolean isAvailable = true;
    private Integer package_id;
}
