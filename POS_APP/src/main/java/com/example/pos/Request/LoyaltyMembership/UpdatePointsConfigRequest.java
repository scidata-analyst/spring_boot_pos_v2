package com.example.pos.Request.LoyaltyMembership;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePointsConfigRequest {
    private Double pointsPerDollar;
    private Double redemptionRate;
    private Integer minimumRedemption;
    private String status;
}
