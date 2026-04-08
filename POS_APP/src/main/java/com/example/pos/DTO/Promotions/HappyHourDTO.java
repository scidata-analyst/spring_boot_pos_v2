package com.example.pos.DTO.Promotions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HappyHourDTO {
    private Long id;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private String daysOfWeek;
    private Double discountPercentage;
    private String applicableProducts;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
