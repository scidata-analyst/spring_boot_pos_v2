package com.example.pos.Request.PaymentAccounting;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCashRegisterRequest {
    @NotBlank(message = "Register name is required")
    private String registerName;
    private Double openingBalance;
    private Double closingBalance;
    private Double cashIn;
    private Double cashOut;
    private String status;
    private LocalDateTime openedAt;
    private LocalDateTime closedAt;
}
