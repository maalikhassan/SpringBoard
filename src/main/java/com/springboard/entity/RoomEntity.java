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
    // DELETED: private Boolean isBooked; <--- I removed this line, but will keep in DTO for admin dash!
    private Boolean isAvailable = true; // Keep this (Maintenance mode)
    private Integer package_id;
}
