package com.springboard.repository;

import com.springboard.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    List<RoomEntity> findByNameContainingIgnoreCase(String name);

    //long countByIsBookedTrue(); deleted this as i removed this field from entity,moved that logic to
    // BookingRepository (countActiveBookings) and updated your Service to use the new way.
}
