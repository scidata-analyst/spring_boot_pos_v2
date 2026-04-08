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
public class DevicesPrintersDTO {
    private Long id;
    private String deviceName;
    private String deviceType;
    private String connectionType;
    private String ipAddress;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
