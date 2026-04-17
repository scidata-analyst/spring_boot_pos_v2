package com.example.pos.services.UsersRoles;

import com.example.pos.dtos.request.UsersRoles.RolesPermissionsRequest;
import com.example.pos.dtos.response.UsersRoles.RolesPermissionsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * =====================================================
 * Service Contract: RolesPermissions
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all() -> get all records
 * - index() -> UI listing (paginated)
 * - view() -> single record view
 * - create() -> create new record
 * - update() -> update existing record
 * - delete() -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface RolesPermissionsService {

    List<RolesPermissionsResponse> all();

    Page<RolesPermissionsResponse> index(Pageable pageable);

    RolesPermissionsResponse view(Long id);

    RolesPermissionsResponse create(RolesPermissionsRequest request);

    RolesPermissionsResponse update(Long id, RolesPermissionsRequest request);

    void delete(Long id);
}
