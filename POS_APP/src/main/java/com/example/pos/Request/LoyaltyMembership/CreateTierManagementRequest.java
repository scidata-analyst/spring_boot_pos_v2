package com.example.pos.Request.LoyaltyMembership;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTierManagementRequest {
    @NotBlank(message = "Tier name is required")
    private String tierName;
    @NotNull(message = "Min points is required")
    private Integer minPoints;
    private Integer maxPoints;
    @NotNull(message = "Discount percentage is required")
    private Double discountPercentage;
    private String benefits;
    private String status;
}
