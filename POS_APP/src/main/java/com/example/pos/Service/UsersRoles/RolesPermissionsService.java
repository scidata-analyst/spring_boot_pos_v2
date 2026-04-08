package com.example.pos.Service.UsersRoles;

import com.example.pos.Entity.UsersRoles.RolesPermissions;
import java.util.List;
import java.util.Optional;

public interface RolesPermissionsService {
    List<RolesPermissions> all();
    List<RolesPermissions> index();
    Optional<RolesPermissions> show(Long id);
    RolesPermissions store(RolesPermissions entity);
    RolesPermissions update(Long id, RolesPermissions entity);
    void destroy(Long id);
}
