package com.scidata_analyst.pos.dto.payment;

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
public class PaymentSummaryDTO {

    private LocalDate date;
    private Long totalTransactions;
    private BigDecimal totalAmount;
    private BigDecimal cashAmount;
    private BigDecimal cardAmount;
    private BigDecimal otherAmount;
    private BigDecimal successfulPayments;
    private BigDecimal failedPayments;
    private BigDecimal pendingPayments;
}
