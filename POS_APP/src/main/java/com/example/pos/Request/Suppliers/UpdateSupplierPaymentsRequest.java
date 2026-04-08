package com.example.pos.Request.Suppliers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSupplierPaymentsRequest {
    private Long supplierId;
    private Double amount;
    private String paymentMethod;
    private String referenceNumber;
    private String status;
    private LocalDateTime paymentDate;
}
