package com.scidata_analyst.pos.request.customer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLoyaltyPointsRequest {

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    @NotNull(message = "Points is required")
    private Double points;

    @NotNull(message = "Operation type is required")
    private LoyaltyOperation operation;

    private String notes;

    public enum LoyaltyOperation {
        ADD, SUBTRACT, SET
    }
}
