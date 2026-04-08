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
public class CreateHeldOrdersRequest {
    @NotBlank(message = "Order number is required")
    private String orderNumber;
    @NotNull(message = "Cart data is required")
    private String cartData;
    private Long cashierId;
    @NotNull(message = "Total amount is required")
    private Double totalAmount;
    private LocalDateTime holdDate;
    private String status;
}
