package com.scidata_analyst.pos.response.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {

    private Long id;
    private String name;
    private String description;
    private Boolean isActive;
    private Long userCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
