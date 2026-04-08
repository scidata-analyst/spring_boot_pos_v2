package com.example.pos.Request.SalesBilling;

import jakarta.validation.constraints.NotBlank;
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
public class CreateTransactionsRequest {
    @NotBlank(message = "Invoice number is required")
    private String invoiceNumber;
    private Long customerId;
    @NotNull(message = "Total amount is required")
    private Double subtotal;
    private Double tax;
    private Double discount;
    @NotNull(message = "Total amount is required")
    private Double totalAmount;
    private String paymentMethod;
    private Long cashierId;
    private String status;
    private LocalDateTime transactionDate;
}
