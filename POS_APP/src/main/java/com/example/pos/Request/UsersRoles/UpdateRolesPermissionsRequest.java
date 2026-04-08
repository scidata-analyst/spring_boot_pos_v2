package com.example.pos.Request.UsersRoles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRolesPermissionsRequest {
    private String roleName;
    private String permissions;
    private String description;
    private String status;
}
