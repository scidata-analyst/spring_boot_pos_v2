package com.example.pos.Request.PaymentAccounting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAPARRequest {
    private String type;
    private Long referenceId;
    private Long customerId;
    private Long supplierId;
    private Double amount;
    private LocalDate dueDate;
    private String status;
}
