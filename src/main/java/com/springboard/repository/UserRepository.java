package com.springboard.repository;

import com.springboard.dto.UserDto;
import com.springboard.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto,Integer> {
}
