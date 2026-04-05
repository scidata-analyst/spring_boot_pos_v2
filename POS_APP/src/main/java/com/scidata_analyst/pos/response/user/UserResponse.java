package com.scidata_analyst.pos.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String fullName;
    private String phone;
    private Boolean isActive;
    private Boolean isAccountLocked;
    private LocalDateTime lastLoginAt;
    private RoleResponse role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
