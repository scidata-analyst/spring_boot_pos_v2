package com.example.pos.Request.POSTerminal;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePOSTerminalRequest {
    @NotBlank(message = "Terminal name is required")
    private String terminalName;
    @NotBlank(message = "Terminal code is required")
    private String terminalCode;
    private Long storeId;
    private String status;
}
