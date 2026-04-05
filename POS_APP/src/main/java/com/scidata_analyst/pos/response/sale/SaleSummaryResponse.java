package com.scidata_analyst.pos.response.sale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleSummaryResponse {

    private Long id;
    private String invoiceNumber;
    private String customerName;
    private BigDecimal total;
    private String paymentMethod;
    private String status;
    private LocalDateTime createdAt;
}
