package com.example.pos.Request.Suppliers;

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
public class CreateSupplierPaymentsRequest {
    @NotNull(message = "Supplier ID is required")
    private Long supplierId;
    @NotNull(message = "Amount is required")
    private Double amount;
    private String paymentMethod;
    private String referenceNumber;
    private String status;
    private LocalDateTime paymentDate;
}
