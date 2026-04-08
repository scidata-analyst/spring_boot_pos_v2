package com.example.pos.DTO.CustomersCRM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseHistoryDTO {
    private Long id;
    private Long customerId;
    private Long transactionId;
    private Double totalAmount;
    private String items;
    private LocalDateTime purchaseDate;
    private LocalDateTime createdAt;
}
