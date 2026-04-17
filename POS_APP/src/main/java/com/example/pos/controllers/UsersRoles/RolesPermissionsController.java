package com.example.pos.controllers.UsersRoles;

import com.example.pos.dtos.request.UsersRoles.RolesPermissionsRequest;
import com.example.pos.dtos.response.UsersRoles.RolesPermissionsResponse;
import com.example.pos.services.UsersRoles.RolesPermissionsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * =====================================================
 * REST Controller: RolesPermissions
 * =====================================================
 *
 * Provides standard REST APIs for RolesPermissions.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/UsersRoles/RolesPermissions")
public class RolesPermissionsController {

    @Autowired
    private RolesPermissionsService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public java.util.List<RolesPermissionsResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     * Query params: page (0-based), size, sort (e.g., ?page=0&size=10&sort=roleName,asc)
     */
    @GetMapping("/index")
    public Page<RolesPermissionsResponse> index(Pageable pageable) {
        return service.index(pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public RolesPermissionsResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public RolesPermissionsResponse create(@RequestBody @Valid RolesPermissionsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public RolesPermissionsResponse update(@PathVariable Long id,
            @RequestBody @Valid RolesPermissionsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete record.
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
