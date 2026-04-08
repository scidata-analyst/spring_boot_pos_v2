package com.example.pos.Request.CustomersCRM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLoyaltyPointsRequest {
    private Long customerId;
    private Integer points;
    private Long transactionId;
    private String type;
    private LocalDate expiryDate;
    private String status;
}
