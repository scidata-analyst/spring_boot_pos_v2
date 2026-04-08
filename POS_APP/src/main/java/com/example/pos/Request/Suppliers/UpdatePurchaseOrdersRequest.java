package com.example.pos.Request.Suppliers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePurchaseOrdersRequest {
    private Long supplierId;
    private String orderNumber;
    private Double totalAmount;
    private String status;
    private LocalDateTime orderDate;
    private LocalDate expectedDelivery;
}
