package com.scidata_analyst.pos.controller.role;

import com.scidata_analyst.pos.dto.role.RoleDTO;
import com.scidata_analyst.pos.dto.user.UserDTO;
import com.scidata_analyst.pos.service.role.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@Valid @RequestBody RoleDTO roleDTO) {
        RoleDTO created = roleService.createRole(roleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
        RoleDTO updated = roleService.updateRole(id, roleDTO);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) {
        RoleDTO role = roleService.getRoleById(id);
        return ResponseEntity.ok(role);
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/active")
    public ResponseEntity<List<RoleDTO>> getAllActiveRoles() {
        List<RoleDTO> roles = roleService.getAllActiveRoles();
        return ResponseEntity.ok(roles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<List<UserDTO>> getRoleUsers(@PathVariable Long id) {
        List<UserDTO> users = roleService.getRoleUsers(id);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}/users/count")
    public ResponseEntity<Long> getRoleUserCount(@PathVariable Long id) {
        Long count = roleService.getRoleUserCount(id);
        return ResponseEntity.ok(count);
    }
}
