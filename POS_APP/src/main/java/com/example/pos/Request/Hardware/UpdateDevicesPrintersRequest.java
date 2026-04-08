package com.example.pos.Request.Hardware;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDevicesPrintersRequest {
    private String deviceName;
    private String deviceType;
    private String connectionType;
    private String ipAddress;
    private String status;
}
