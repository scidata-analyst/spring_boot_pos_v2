package com.example.pos.Request.SalesBilling;

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
public class CreateReturnsRefundsRequest {
    private Long transactionId;
    private Long productId;
    @NotNull(message = "Quantity is required")
    private Integer quantity;
    @NotNull(message = "Refund amount is required")
    private Double refundAmount;
    private String reason;
    private String status;
    private LocalDateTime returnDate;
}
