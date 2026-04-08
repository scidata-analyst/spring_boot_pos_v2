package com.example.pos.DTO.Suppliers;

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
public class PurchaseOrdersDTO {
    private Long id;
    private Long supplierId;
    private String orderNumber;
    private Double totalAmount;
    private String status;
    private LocalDateTime orderDate;
    private LocalDate expectedDelivery;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
