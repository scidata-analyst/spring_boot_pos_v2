package com.example.pos.DTO.UsersRoles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CashierAccountsDTO {
    private Long id;
    private String username;
    private String password;
    private String employeeName;
    private String email;
    private String phoneNumber;
    private Long roleId;
    private String status;
    private LocalDateTime lastLogin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
