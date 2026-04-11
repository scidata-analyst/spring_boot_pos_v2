package com.example.pos.controllers.UsersRoles;

import com.example.pos.dtos.request.UsersRoles.ActivityLogRequest;
import com.example.pos.dtos.response.UsersRoles.ActivityLogResponse;
import com.example.pos.services.UsersRoles.ActivityLogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: ActivityLog
 * =====================================================
 *
 * Provides standard CRUD APIs for ActivityLog.
 * All responses are returned using ActivityLogResponse DTO.
 *
 * Endpoints:
 * - GET    /api/UsersRoles/ActivityLog
 * - GET    /api/UsersRoles/ActivityLog/{id}
 * - POST   /api/UsersRoles/ActivityLog
 * - PUT    /api/UsersRoles/ActivityLog/{id}
 * - DELETE /api/UsersRoles/ActivityLog/{id}
 */
@RestController
@RequestMapping("/api/UsersRoles/ActivityLog")
public class ActivityLogController {

    @Autowired
    private ActivityLogService service;

    /**
     * Retrieve all ActivityLog records.
     *
     * @return List of ActivityLogResponse
     */
    @GetMapping
    public List<ActivityLogResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single ActivityLog by ID.
     *
     * @param id ID of the ActivityLog
     * @return ActivityLogResponse
     */
    @GetMapping("/{id}")
    public ActivityLogResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new ActivityLog record.
     *
     * @param request request DTO
     * @return created ActivityLogResponse
     */
    @PostMapping
    public ActivityLogResponse create(@RequestBody @Valid ActivityLogRequest request) {
        return service.create(request);
    }

    /**
     * Update existing ActivityLog record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated ActivityLogResponse
     */
    @PutMapping("/{id}")
    public ActivityLogResponse update(@PathVariable Long id,
                                         @RequestBody @Valid ActivityLogRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a ActivityLog record.
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
