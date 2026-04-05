package com.scidata_analyst.pos.service.role;

import com.scidata_analyst.pos.dto.role.RoleDTO;
import com.scidata_analyst.pos.dto.user.UserDTO;

import java.util.List;

public interface RoleService {

    RoleDTO createRole(RoleDTO roleDTO);

    RoleDTO updateRole(Long id, RoleDTO roleDTO);

    RoleDTO getRoleById(Long id);

    RoleDTO getRoleByName(String name);

    List<RoleDTO> getAllRoles();

    List<RoleDTO> getAllActiveRoles();

    void deleteRole(Long id);

    boolean existsByName(String name);

    List<UserDTO> getRoleUsers(Long roleId);

    Long getRoleUserCount(Long roleId);
}
