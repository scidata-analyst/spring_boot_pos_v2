package com.example.pos.Request.LoyaltyMembership;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePointsConfigRequest {
    @NotNull(message = "Points per dollar is required")
    private Double pointsPerDollar;
    @NotNull(message = "Redemption rate is required")
    private Double redemptionRate;
    private Integer minimumRedemption;
    private String status;
}
