package com.example.pos.Controller.UsersRoles;

import com.example.pos.DTO.UsersRoles.RolesPermissionsDTO;
import com.example.pos.Entity.UsersRoles.RolesPermissions;
import com.example.pos.Request.UsersRoles.CreateRolesPermissionsRequest;
import com.example.pos.Request.UsersRoles.UpdateRolesPermissionsRequest;
import com.example.pos.Response.UsersRoles.RolesPermissionsResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles-permissions")
public class RolesPermissionsController {

    @GetMapping
    public ResponseEntity<Page<RolesPermissionsResponse>> index(Pageable pageable) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesPermissionsResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<RolesPermissionsResponse> store(@Valid @RequestBody CreateRolesPermissionsRequest request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesPermissionsResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateRolesPermissionsRequest request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
