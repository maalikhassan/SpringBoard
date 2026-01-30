package com.springboard.repository;

import com.springboard.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {
    // The Logic: "Select count > 0 if any booking exists for this ROOM
    // where the NEW start time is BEFORE the EXISTING end time
    // AND the NEW end time is AFTER the EXISTING start time."

//  standard names work perfectly
    List<BookingEntity> findByCustomerId(Integer id);
    List<BookingEntity> findByRoomId(Integer id);

    // Update your @Query to use the new variable names (b.roomId, etc.)
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END " +
            "FROM BookingEntity b " +
            "WHERE b.roomId = :roomId " +
            "AND b.endTime > :newStart " +
            "AND b.startTime < :newEnd")
    boolean existsOverlap(@Param("roomId") Integer roomId,
                          @Param("newStart") LocalDateTime newStart,
                          @Param("newEnd") LocalDateTime newEnd);

    // --- NEW METHODS FOR DASHBOARD & LIVE STATUS ---

    // 1. Check if specific Room is busy RIGHT NOW (For Room List)
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END " +
            "FROM BookingEntity b " +
            "WHERE b.roomId = :roomId " +
            "AND b.startTime < :now " +
            "AND b.endTime > :now")
    boolean isRoomOccupiedNow(@Param("roomId") Integer roomId,
                              @Param("now") LocalDateTime now);

    // 2. Count TOTAL active bookings RIGHT NOW (For Dashboard Stats)
    @Query("SELECT COUNT(b) FROM BookingEntity b " +
            "WHERE b.startTime < :now AND b.endTime > :now")
    long countActiveBookings(@Param("now") LocalDateTime now);

}

