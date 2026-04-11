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
 * Provides standard REST APIs for ActivityLog.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/UsersRoles/ActivityLog")
public class ActivityLogController {

    @Autowired
    private ActivityLogService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<ActivityLogResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<ActivityLogResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public ActivityLogResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public ActivityLogResponse create(@RequestBody @Valid ActivityLogRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public ActivityLogResponse update(@PathVariable Long id,
            @RequestBody @Valid ActivityLogRequest request) {
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
