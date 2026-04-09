package com.example.pos.controllers.Loyalty;

import com.example.pos.dtos.request.Loyalty.RetentionRequest;
import com.example.pos.dtos.response.Loyalty.RetentionResponse;
import com.example.pos.services.Loyalty.RetentionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Retention operations.
 * Provides standard CRUD endpoints for Retention.
 * All responses are returned using RetentionResponse DTO.
 */
@RestController
@RequestMapping(""/api/Loyalty/Retention"")
public class RetentionController {

    @Autowired
    private RetentionService service;

    /**
     * Retrieve all Retention records.
     * @return List of RetentionResponse
     */
    @GetMapping
    public List<RetentionResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Retention by its ID.
     * @param id ID of the Retention
     * @return RetentionResponse object
     */
    @GetMapping(""/{id}"")
    public RetentionResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Retention record.
     * @param request DTO containing the Retention data
     * @return Created RetentionResponse
     */
    @PostMapping
    public RetentionResponse create(@RequestBody @Valid RetentionRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Retention by its ID.
     * @param id ID of the Retention to update
     * @param request DTO containing updated data
     * @return Updated RetentionResponse
     */
    @PutMapping(""/{id}"")
    public RetentionResponse update(@PathVariable Long id, @RequestBody @Valid RetentionRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Retention by its ID.
     * @param id ID of the Retention to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
