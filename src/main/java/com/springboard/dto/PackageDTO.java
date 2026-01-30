package com.springboard.dto;

import com.springboard.util.PackageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PackageDTO {
    private Integer id;
    private PackageType type;
    private Double price;
    private String description;
}
