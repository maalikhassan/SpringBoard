package com.springboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String city;
    private Integer phone;
}
