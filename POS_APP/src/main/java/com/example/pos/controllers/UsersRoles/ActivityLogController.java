package com.example.pos.controllers.UsersRoles;

import com.example.pos.dtos.request.UsersRoles.ActivityLogRequest;
import com.example.pos.dtos.response.UsersRoles.ActivityLogResponse;
import com.example.pos.services.UsersRoles.ActivityLogService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public java.util.List<ActivityLogResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     * Query params: page (0-based), size, sort (e.g., ?page=0&size=10&sort=timestamp,desc)
     */
    @GetMapping("/index")
    public Page<ActivityLogResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
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
