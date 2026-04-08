package com.example.pos.DTO.SalesBilling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnsRefundsDTO {
    private Long id;
    private Long transactionId;
    private Long productId;
    private Integer quantity;
    private Double refundAmount;
    private String reason;
    private String status;
    private LocalDateTime returnDate;
    private LocalDateTime createdAt;
}
