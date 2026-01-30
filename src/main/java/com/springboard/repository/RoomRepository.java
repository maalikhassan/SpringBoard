package com.springboard.repository;

import com.springboard.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    List<RoomEntity> findByNameContainingIgnoreCase(String name);

    long countByIsBookedTrue();
}
