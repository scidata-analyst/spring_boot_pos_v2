package com.scidata_analyst.pos.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPurchaseHistoryDTO {

    private Long customerId;
    private String customerName;
    private Long totalOrders;
    private BigDecimal totalSpent;
    private BigDecimal averageOrderValue;
    private LocalDate firstPurchaseDate;
    private LocalDate lastPurchaseDate;
    private Double loyaltyPoints;
    private String preferredPaymentMethod;
}
