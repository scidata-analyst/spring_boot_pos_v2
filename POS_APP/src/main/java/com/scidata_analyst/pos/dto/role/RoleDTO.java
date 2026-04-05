package com.scidata_analyst.pos.dto.role;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private Long id;

    @NotBlank(message = "Role name is required")
    private String name;

    private String description;

    private Boolean isActive;

    private Long userCount;

    private Set<String> permissions;
}
