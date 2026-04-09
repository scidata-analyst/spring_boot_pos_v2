package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.StockMovementRequest;
import com.example.pos.dtos.response.Products.StockMovementResponse;
import com.example.pos.services.Products.StockMovementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing StockMovement operations.
 * Provides standard CRUD endpoints for StockMovement.
 * All responses are returned using StockMovementResponse DTO.
 */
@RestController
@RequestMapping(""/api/Products/StockMovement"")
public class StockMovementController {

    @Autowired
    private StockMovementService service;

    /**
     * Retrieve all StockMovement records.
     * @return List of StockMovementResponse
     */
    @GetMapping
    public List<StockMovementResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single StockMovement by its ID.
     * @param id ID of the StockMovement
     * @return StockMovementResponse object
     */
    @GetMapping(""/{id}"")
    public StockMovementResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new StockMovement record.
     * @param request DTO containing the StockMovement data
     * @return Created StockMovementResponse
     */
    @PostMapping
    public StockMovementResponse create(@RequestBody @Valid StockMovementRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing StockMovement by its ID.
     * @param id ID of the StockMovement to update
     * @param request DTO containing updated data
     * @return Updated StockMovementResponse
     */
    @PutMapping(""/{id}"")
    public StockMovementResponse update(@PathVariable Long id, @RequestBody @Valid StockMovementRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a StockMovement by its ID.
     * @param id ID of the StockMovement to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
