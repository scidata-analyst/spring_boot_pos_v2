package com.example.pos.Response.UsersRoles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLogResponse {
    private Long id;
    private Long userId;
    private String action;
    private String module;
    private String description;
    private String ipAddress;
    private LocalDateTime timestamp;
    private LocalDateTime createdAt;
}
