package com.example.pos.Request.PaymentAccounting;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAPARRequest {
    @NotBlank(message = "Type is required")
    private String type;
    private Long referenceId;
    private Long customerId;
    private Long supplierId;
    @NotNull(message = "Amount is required")
    private Double amount;
    private LocalDate dueDate;
    private String status;
}
