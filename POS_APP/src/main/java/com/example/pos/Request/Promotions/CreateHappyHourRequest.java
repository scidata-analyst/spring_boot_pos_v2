package com.example.pos.Request.Promotions;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateHappyHourRequest {
    @NotBlank(message = "Name is required")
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private String daysOfWeek;
    private Double discountPercentage;
    private String applicableProducts;
    private String status;
}
