package com.example.pos.DTO.PaymentAccounting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CashRegisterDTO {
    private Long id;
    private String registerName;
    private Double openingBalance;
    private Double closingBalance;
    private Double cashIn;
    private Double cashOut;
    private String status;
    private LocalDateTime openedAt;
    private LocalDateTime closedAt;
    private LocalDateTime createdAt;
}
