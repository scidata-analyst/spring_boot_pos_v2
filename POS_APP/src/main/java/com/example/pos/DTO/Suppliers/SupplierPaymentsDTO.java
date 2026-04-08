package com.example.pos.DTO.Suppliers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierPaymentsDTO {
    private Long id;
    private Long supplierId;
    private Double amount;
    private String paymentMethod;
    private String referenceNumber;
    private String status;
    private LocalDateTime paymentDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
