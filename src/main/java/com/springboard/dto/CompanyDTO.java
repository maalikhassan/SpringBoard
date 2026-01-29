package com.springboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyDTO {

    private Integer id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String email;
    private String website;
    private String description;
    private Boolean isActive;
    private LocalDateTime createdAt;
}

