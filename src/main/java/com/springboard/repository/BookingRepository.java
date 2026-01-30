package com.springboard.repository;

import com.springboard.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {

}

