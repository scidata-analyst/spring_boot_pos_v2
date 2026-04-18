package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.StockMovementRequest;
import com.example.pos.dtos.response.Products.StockMovementResponse;
import com.example.pos.services.Products.StockMovementService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * =====================================================
 * REST Controller: StockMovement
 * =====================================================
 *
 * Provides standard REST APIs for StockMovement.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Products/StockMovement")
public class StockMovementController {

    @Autowired
    private StockMovementService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<StockMovementResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public Page<StockMovementResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public StockMovementResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public StockMovementResponse create(@RequestBody @Valid StockMovementRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public StockMovementResponse update(@PathVariable Long id,
            @RequestBody @Valid StockMovementRequest request) {
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
