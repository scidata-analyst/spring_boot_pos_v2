package com.example.pos.services.UsersRoles;

import com.example.pos.dtos.request.UsersRoles.ActivityLogRequest;
import com.example.pos.dtos.response.UsersRoles.ActivityLogResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: ActivityLog
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
public interface ActivityLogService {

    List<ActivityLogResponse> all();

    List<ActivityLogResponse> index();

    ActivityLogResponse view(Long id);

    ActivityLogResponse create(ActivityLogRequest request);

    ActivityLogResponse update(Long id, ActivityLogRequest request);

    void delete(Long id);
}
