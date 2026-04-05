package com.scidata_analyst.pos.response.sale;

import com.scidata_analyst.pos.response.customer.CustomerSummaryResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponse {

    private Long id;
    private String invoiceNumber;
    private CustomerSummaryResponse customer;
    private UserSummaryResponse user;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal total;
    private BigDecimal amountPaid;
    private BigDecimal changeAmount;
    private String paymentMethod;
    private String status;
    private String notes;
    private List<SaleItemResponse> items;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserSummaryResponse {
        private Long id;
        private String username;
        private String firstName;
        private String lastName;
    }
}
