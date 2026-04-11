package com.example.pos.services.UsersRoles;

import com.example.pos.dtos.request.UsersRoles.RolesPermissionsRequest;
import com.example.pos.dtos.response.UsersRoles.RolesPermissionsResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: RolesPermissions
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all() -> get all records
 * - index() -> UI listing (paginated later if needed)
 * - view() -> single record view
 * - create() -> create new record
 * - update() -> update existing record
 * - delete() -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface RolesPermissionsService {

    List<RolesPermissionsResponse> all();

    List<RolesPermissionsResponse> index();

    RolesPermissionsResponse view(Long id);

    RolesPermissionsResponse create(RolesPermissionsRequest request);

    RolesPermissionsResponse update(Long id, RolesPermissionsRequest request);

    void delete(Long id);
}
