package com.example.pos.controllers.Sales;

import com.example.pos.dtos.request.Sales.ReturnsRequest;
import com.example.pos.dtos.response.Sales.ReturnsResponse;
import com.example.pos.services.Sales.ReturnsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Returns operations.
 * Provides standard CRUD endpoints for Returns.
 * All responses are returned using ReturnsResponse DTO.
 */
@RestController
@RequestMapping("/api/Sales/Returns")
public class ReturnsController {

    @Autowired
    private ReturnsService service;

    /**
     * Retrieve all Returns records.
     * 
     * @return List of ReturnsResponse
     */
    @GetMapping
    public List<ReturnsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Returns by its ID.
     * 
     * @param id ID of the Returns
     * @return ReturnsResponse object
     */
    @GetMapping("/{id}")
    public ReturnsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new Returns record.
     * 
     * @param request DTO containing the Returns data
     * @return Created ReturnsResponse
     */
    @PostMapping
    public ReturnsResponse create(@RequestBody @Valid ReturnsRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Returns by its ID.
     * 
     * @param id      ID of the Returns to update
     * @param request DTO containing updated data
     * @return Updated ReturnsResponse
     */
    @PutMapping("/{id}")
    public ReturnsResponse update(@PathVariable Long id, @RequestBody @Valid ReturnsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Returns by its ID.
     * 
     * @param id ID of the Returns to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
