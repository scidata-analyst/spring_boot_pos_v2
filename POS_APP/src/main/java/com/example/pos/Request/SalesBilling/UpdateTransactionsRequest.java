package com.example.pos.Request.SalesBilling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTransactionsRequest {
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
}
