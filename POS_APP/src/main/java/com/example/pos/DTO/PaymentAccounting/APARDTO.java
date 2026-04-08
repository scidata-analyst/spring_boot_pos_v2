package com.example.pos.DTO.PaymentAccounting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APARDTO {
    private Long id;
    private String type;
    private Long referenceId;
    private Long customerId;
    private Long supplierId;
    private Double amount;
    private LocalDate dueDate;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
