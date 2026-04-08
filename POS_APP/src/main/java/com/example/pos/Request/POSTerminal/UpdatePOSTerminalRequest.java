package com.example.pos.Request.POSTerminal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePOSTerminalRequest {
    private String terminalName;
    private String terminalCode;
    private Long storeId;
    private String status;
}
