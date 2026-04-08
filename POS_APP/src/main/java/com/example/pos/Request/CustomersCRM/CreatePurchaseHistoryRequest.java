package com.example.pos.Request.CustomersCRM;

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
public class CreatePurchaseHistoryRequest {
    @NotNull(message = "Customer ID is required")
    private Long customerId;
    private Long transactionId;
    @NotNull(message = "Total amount is required")
    private Double totalAmount;
    private String items;
    private LocalDateTime purchaseDate;
}
