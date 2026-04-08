package com.example.pos.DTO.SalesBilling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoicesDTO {
    private Long id;
    private String invoiceNumber;
    private Long transactionId;
    private Long customerId;
    private Double totalAmount;
    private Double amountPaid;
    private Double balanceDue;
    private String status;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
