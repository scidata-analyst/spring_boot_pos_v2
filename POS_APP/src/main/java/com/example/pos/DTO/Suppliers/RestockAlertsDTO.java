package com.example.pos.DTO.Suppliers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestockAlertsDTO {
    private Long id;
    private Long productId;
    private Integer currentStock;
    private Integer reorderLevel;
    private String status;
    private LocalDateTime alertDate;
    private LocalDateTime createdAt;
}
