package com.scidata_analyst.pos.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String token;
    private String refreshToken;
    private String role;
    private Long expiresIn;
}
