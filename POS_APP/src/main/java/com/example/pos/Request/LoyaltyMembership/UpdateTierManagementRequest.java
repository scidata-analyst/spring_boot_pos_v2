package com.example.pos.Request.LoyaltyMembership;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTierManagementRequest {
    private String tierName;
    private Integer minPoints;
    private Integer maxPoints;
    private Double discountPercentage;
    private String benefits;
    private String status;
}
