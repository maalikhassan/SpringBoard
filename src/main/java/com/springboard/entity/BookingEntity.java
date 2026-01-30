package com.springboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Bookings")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // FIX: Rename to camelCase, map to DB column
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "room_id")
    private Integer roomId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String purpose;
    private Integer numberOfGuests;
}
