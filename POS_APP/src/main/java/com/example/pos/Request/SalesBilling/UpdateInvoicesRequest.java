package com.example.pos.Request.SalesBilling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoicesRequest {
    private String invoiceNumber;
    private Long transactionId;
    private Long customerId;
    private Double totalAmount;
    private Double amountPaid;
    private Double balanceDue;
    private String status;
    private LocalDate dueDate;
}
