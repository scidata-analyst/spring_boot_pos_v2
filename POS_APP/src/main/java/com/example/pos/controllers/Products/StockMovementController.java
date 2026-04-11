package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.StockMovementRequest;
import com.example.pos.dtos.response.Products.StockMovementResponse;
import com.example.pos.services.Products.StockMovementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: StockMovement
 * =====================================================
 *
 * Provides standard CRUD APIs for StockMovement.
 * All responses are returned using StockMovementResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Products/StockMovement
 * - GET    /api/Products/StockMovement/{id}
 * - POST   /api/Products/StockMovement
 * - PUT    /api/Products/StockMovement/{id}
 * - DELETE /api/Products/StockMovement/{id}
 */
@RestController
@RequestMapping("/api/Products/StockMovement")
public class StockMovementController {

    @Autowired
    private StockMovementService service;

    /**
     * Retrieve all StockMovement records.
     *
     * @return List of StockMovementResponse
     */
    @GetMapping
    public List<StockMovementResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single StockMovement by ID.
     *
     * @param id ID of the StockMovement
     * @return StockMovementResponse
     */
    @GetMapping("/{id}")
    public StockMovementResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new StockMovement record.
     *
     * @param request request DTO
     * @return created StockMovementResponse
     */
    @PostMapping
    public StockMovementResponse create(@RequestBody @Valid StockMovementRequest request) {
        return service.create(request);
    }

    /**
     * Update existing StockMovement record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated StockMovementResponse
     */
    @PutMapping("/{id}")
    public StockMovementResponse update(@PathVariable Long id,
                                         @RequestBody @Valid StockMovementRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a StockMovement record.
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
