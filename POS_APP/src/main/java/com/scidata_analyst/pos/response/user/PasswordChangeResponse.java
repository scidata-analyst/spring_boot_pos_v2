package com.scidata_analyst.pos.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordChangeResponse {

    private Long userId;
    private String username;
    private Boolean success;
    private String message;
    private String updatedAt;
}
