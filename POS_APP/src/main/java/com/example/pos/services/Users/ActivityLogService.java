package com.example.pos.services.Users;

import com.example.pos.dtos.request.Users.ActivityLogRequest;
import com.example.pos.dtos.response.Users.ActivityLogResponse;
import java.util.List;

/**
 * Service interface for ActivityLog.
 * Defines standard CRUD operations for ActivityLog, same as Controller methods.
 */
public interface ActivityLogService {

    /**
     * Retrieve all ActivityLog records.
     * @return List of ActivityLogResponse
     */
    List<ActivityLogResponse> getAll();

    /**
     * Retrieve a single ActivityLog by its ID.
     * @param id ID of the ActivityLog
     * @return ActivityLogResponse object
     */
    ActivityLogResponse get(Long id);

    /**
     * Create a new ActivityLog record.
     * @param request DTO containing the ActivityLog data
     * @return Created ActivityLogResponse
     */
    ActivityLogResponse create(ActivityLogRequest request);

    /**
     * Update an existing ActivityLog by its ID.
     * @param id ID of the ActivityLog to update
     * @param request DTO containing updated data
     * @return Updated ActivityLogResponse
     */
    ActivityLogResponse update(Long id, ActivityLogRequest request);

    /**
     * Delete a ActivityLog by its ID.
     * @param id ID of the ActivityLog to delete
     */
    void delete(Long id);
}
