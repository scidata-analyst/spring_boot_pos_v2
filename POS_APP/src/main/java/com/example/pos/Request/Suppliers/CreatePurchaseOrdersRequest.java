package com.example.pos.Request.Suppliers;

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
public class CreatePurchaseOrdersRequest {
    @NotNull(message = "Supplier ID is required")
    private Long supplierId;
    @NotBlank(message = "Order number is required")
    private String orderNumber;
    private Double totalAmount;
    private String status;
    private LocalDateTime orderDate;
    private LocalDate expectedDelivery;
}
