package com.example.pos.Request.PaymentAccounting;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReconciliationRequest {
    @NotNull(message = "Register ID is required")
    private Long registerId;
    @NotNull(message = "Expected amount is required")
    private Double expectedAmount;
    @NotNull(message = "Actual amount is required")
    private Double actualAmount;
    private Double variance;
    private String notes;
    private String status;
    private LocalDateTime reconciledAt;
}
