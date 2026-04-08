package com.example.pos.DTO.SalesBilling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsDTO {
    private Long id;
    private String invoiceNumber;
    private Long customerId;
    private Double subtotal;
    private Double tax;
    private Double discount;
    private Double totalAmount;
    private String paymentMethod;
    private Long cashierId;
    private String status;
    private LocalDateTime transactionDate;
    private LocalDateTime createdAt;
}
