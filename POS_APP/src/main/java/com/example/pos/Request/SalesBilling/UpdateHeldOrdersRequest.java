package com.example.pos.Request.SalesBilling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHeldOrdersRequest {
    private String orderNumber;
    private String cartData;
    private Long cashierId;
    private Double totalAmount;
    private LocalDateTime holdDate;
    private String status;
}
