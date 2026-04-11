package com.example.pos.controllers.ReportsAnalytics;

import com.example.pos.dtos.request.ReportsAnalytics.CustomBuilderRequest;
import com.example.pos.dtos.response.ReportsAnalytics.CustomBuilderResponse;
import com.example.pos.services.ReportsAnalytics.CustomBuilderService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: CustomBuilder
 * =====================================================
 *
 * Provides standard REST APIs for CustomBuilder.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/ReportsAnalytics/CustomBuilder")
public class CustomBuilderController {

    @Autowired
    private CustomBuilderService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<CustomBuilderResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<CustomBuilderResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public CustomBuilderResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public CustomBuilderResponse create(@RequestBody @Valid CustomBuilderRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public CustomBuilderResponse update(@PathVariable Long id,
            @RequestBody @Valid CustomBuilderRequest request) {
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
