package com.springboard.repository;

import com.springboard.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {
    // The Logic: "Select count > 0 if any booking exists for this ROOM
    // where the NEW start time is BEFORE the EXISTING end time
    // AND the NEW end time is AFTER the EXISTING start time."
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END " +
            "FROM BookingEntity b " +
            "WHERE b.room_id = :roomId " +
            "AND b.endTime > :newStart " +
            "AND b.startTime < :newEnd")
    boolean existsOverlap(@Param("roomId") Integer roomId,
                          @Param("newStart") LocalDateTime newStart,
                          @Param("newEnd") LocalDateTime newEnd);
}

