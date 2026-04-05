package com.scidata_analyst.pos.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSessionDTO {

    private Long userId;
    private String username;
    private String fullName;
    private String email;
    private String role;
    private String token;
    private String refreshToken;
    private Long expiresIn;
    private String loginTime;
    private String ipAddress;
}
