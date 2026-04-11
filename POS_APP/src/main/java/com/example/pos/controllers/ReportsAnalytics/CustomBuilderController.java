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
 * Provides standard CRUD APIs for CustomBuilder.
 * All responses are returned using CustomBuilderResponse DTO.
 *
 * Endpoints:
 * - GET    /api/ReportsAnalytics/CustomBuilder
 * - GET    /api/ReportsAnalytics/CustomBuilder/{id}
 * - POST   /api/ReportsAnalytics/CustomBuilder
 * - PUT    /api/ReportsAnalytics/CustomBuilder/{id}
 * - DELETE /api/ReportsAnalytics/CustomBuilder/{id}
 */
@RestController
@RequestMapping("/api/ReportsAnalytics/CustomBuilder")
public class CustomBuilderController {

    @Autowired
    private CustomBuilderService service;

    /**
     * Retrieve all CustomBuilder records.
     *
     * @return List of CustomBuilderResponse
     */
    @GetMapping
    public List<CustomBuilderResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single CustomBuilder by ID.
     *
     * @param id ID of the CustomBuilder
     * @return CustomBuilderResponse
     */
    @GetMapping("/{id}")
    public CustomBuilderResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new CustomBuilder record.
     *
     * @param request request DTO
     * @return created CustomBuilderResponse
     */
    @PostMapping
    public CustomBuilderResponse create(@RequestBody @Valid CustomBuilderRequest request) {
        return service.create(request);
    }

    /**
     * Update existing CustomBuilder record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated CustomBuilderResponse
     */
    @PutMapping("/{id}")
    public CustomBuilderResponse update(@PathVariable Long id,
                                         @RequestBody @Valid CustomBuilderRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a CustomBuilder record.
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
