package com.scidata_analyst.pos.response.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoyaltyPointsResponse {

    private Long customerId;
    private String customerName;
    private Double previousPoints;
    private Double pointsChanged;
    private Double currentPoints;
    private String operation;
    private String notes;
    private String updatedAt;
}
