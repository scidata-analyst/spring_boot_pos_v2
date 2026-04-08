package com.example.pos.DTO.LoyaltyMembership;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointsConfigDTO {
    private Long id;
    private Double pointsPerDollar;
    private Double redemptionRate;
    private Integer minimumRedemption;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
