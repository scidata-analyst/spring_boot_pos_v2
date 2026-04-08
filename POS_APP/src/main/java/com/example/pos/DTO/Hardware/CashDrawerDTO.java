package com.example.pos.DTO.Hardware;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CashDrawerDTO {
    private Long id;
    private String drawerNumber;
    private String status;
    private String connectedDevice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
