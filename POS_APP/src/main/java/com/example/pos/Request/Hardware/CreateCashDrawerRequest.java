package com.example.pos.Request.Hardware;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCashDrawerRequest {
    @NotBlank(message = "Drawer number is required")
    private String drawerNumber;
    private String status;
    private String connectedDevice;
}
