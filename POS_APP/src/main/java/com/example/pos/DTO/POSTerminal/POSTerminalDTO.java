package com.example.pos.DTO.POSTerminal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class POSTerminalDTO {
    private Long id;
    private String terminalName;
    private String terminalCode;
    private Long storeId;
    private String status;
    private LocalDateTime lastSync;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
