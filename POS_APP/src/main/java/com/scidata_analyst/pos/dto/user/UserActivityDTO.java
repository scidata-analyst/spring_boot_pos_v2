package com.scidata_analyst.pos.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivityDTO {

    private Long userId;
    private String username;
    private String fullName;
    private LocalDateTime lastLoginAt;
    private LocalDateTime lastActivityAt;
    private String lastAction;
    private Integer sessionCount;
    private Boolean isActive;
}
