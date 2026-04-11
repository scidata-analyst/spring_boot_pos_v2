package com.example.pos.controllers.UsersRoles;

import com.example.pos.dtos.request.UsersRoles.RolesPermissionsRequest;
import com.example.pos.dtos.response.UsersRoles.RolesPermissionsResponse;
import com.example.pos.services.UsersRoles.RolesPermissionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: RolesPermissions
 * =====================================================
 *
 * Provides standard CRUD APIs for RolesPermissions.
 * All responses are returned using RolesPermissionsResponse DTO.
 *
 * Endpoints:
 * - GET    /api/UsersRoles/RolesPermissions
 * - GET    /api/UsersRoles/RolesPermissions/{id}
 * - POST   /api/UsersRoles/RolesPermissions
 * - PUT    /api/UsersRoles/RolesPermissions/{id}
 * - DELETE /api/UsersRoles/RolesPermissions/{id}
 */
@RestController
@RequestMapping("/api/UsersRoles/RolesPermissions")
public class RolesPermissionsController {

    @Autowired
    private RolesPermissionsService service;

    /**
     * Retrieve all RolesPermissions records.
     *
     * @return List of RolesPermissionsResponse
     */
    @GetMapping
    public List<RolesPermissionsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single RolesPermissions by ID.
     *
     * @param id ID of the RolesPermissions
     * @return RolesPermissionsResponse
     */
    @GetMapping("/{id}")
    public RolesPermissionsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new RolesPermissions record.
     *
     * @param request request DTO
     * @return created RolesPermissionsResponse
     */
    @PostMapping
    public RolesPermissionsResponse create(@RequestBody @Valid RolesPermissionsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing RolesPermissions record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated RolesPermissionsResponse
     */
    @PutMapping("/{id}")
    public RolesPermissionsResponse update(@PathVariable Long id,
                                         @RequestBody @Valid RolesPermissionsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a RolesPermissions record.
     *
     * @param id record ID
     * @return success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
