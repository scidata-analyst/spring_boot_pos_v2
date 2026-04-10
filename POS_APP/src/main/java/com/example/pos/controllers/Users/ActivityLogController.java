package com.example.pos.controllers.Users;

import com.example.pos.dtos.request.Users.ActivityLogRequest;
import com.example.pos.dtos.response.Users.ActivityLogResponse;
import com.example.pos.services.Users.ActivityLogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing ActivityLog operations.
 * Provides standard CRUD endpoints for ActivityLog.
 * All responses are returned using ActivityLogResponse DTO.
 */
@RestController
@RequestMapping("/api/Users/ActivityLog")
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
     * Retrieve a single ActivityLog by its ID.
     * 
     * @param id ID of the ActivityLog
     * @return ActivityLogResponse object
     */
    @GetMapping("/{id}")
    public ActivityLogResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new ActivityLog record.
     * 
     * @param request DTO containing the ActivityLog data
     * @return Created ActivityLogResponse
     */
    @PostMapping
    public ActivityLogResponse create(@RequestBody @Valid ActivityLogRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing ActivityLog by its ID.
     * 
     * @param id      ID of the ActivityLog to update
     * @param request DTO containing updated data
     * @return Updated ActivityLogResponse
     */
    @PutMapping("/{id}")
    public ActivityLogResponse update(@PathVariable Long id, @RequestBody @Valid ActivityLogRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a ActivityLog by its ID.
     * 
     * @param id ID of the ActivityLog to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
