package com.scidata_analyst.pos.dto.sale;

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
public class SalesReportDTO {

    private LocalDate date;
    private Long totalTransactions;
    private BigDecimal grossSales;
    private BigDecimal totalDiscounts;
    private BigDecimal totalTax;
    private BigDecimal netSales;
    private BigDecimal averageTransactionValue;
    private String topPaymentMethod;
    private Long itemsSold;
}
