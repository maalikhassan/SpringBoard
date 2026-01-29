package com.springboard.repository;

import com.springboard.dto.UserDto;
import com.springboard.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity> findAllByName(String name);
}
