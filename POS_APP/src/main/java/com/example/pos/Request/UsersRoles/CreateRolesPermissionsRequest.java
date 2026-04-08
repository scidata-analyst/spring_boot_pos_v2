package com.example.pos.Request.UsersRoles;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRolesPermissionsRequest {
    @NotBlank(message = "Role name is required")
    private String roleName;
    private String permissions;
    private String description;
    private String status;
}
