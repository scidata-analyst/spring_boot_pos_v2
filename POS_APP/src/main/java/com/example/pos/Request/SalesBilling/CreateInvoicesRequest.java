package com.example.pos.Request.SalesBilling;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoicesRequest {
    @NotBlank(message = "Invoice number is required")
    private String invoiceNumber;
    private Long transactionId;
    private Long customerId;
    @NotNull(message = "Total amount is required")
    private Double totalAmount;
    private Double amountPaid;
    private Double balanceDue;
    private String status;
    private LocalDate dueDate;
}
