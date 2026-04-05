package com.scidata_analyst.pos.dto.sale;

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
public class SaleSummaryDTO {

    private Long id;
    private String invoiceNumber;
    private String customerName;
    private String cashierName;
    private Integer itemCount;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal total;
    private String paymentMethod;
    private String status;
    private LocalDateTime createdAt;
}
