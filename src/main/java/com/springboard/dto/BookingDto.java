package com.springboard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingDto {
    private Integer id;
    // FIX: Rename to camelCase to match Entity
    // Use @JsonProperty so Postman/Frontend still sends "customer_id"
    @JsonProperty("customer_id")
    private Integer customerId;

    @JsonProperty("company_id")
    private Integer companyId;

    @JsonProperty("room_id")
    private Integer roomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String purpose;
    private Integer numberOfGuests;

    @JsonProperty("package_id")
    private Integer packageId; //to also choose pkg
}
