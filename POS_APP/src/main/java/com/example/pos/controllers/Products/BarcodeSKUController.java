package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.BarcodeSKURequest;
import com.example.pos.dtos.response.Products.BarcodeSKUResponse;
import com.example.pos.services.Products.BarcodeSKUService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: BarcodeSKU
 * =====================================================
 *
 * Provides standard REST APIs for BarcodeSKU.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Products/BarcodeSKU")
public class BarcodeSKUController {

    @Autowired
    private BarcodeSKUService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<BarcodeSKUResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<BarcodeSKUResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public BarcodeSKUResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public BarcodeSKUResponse create(@RequestBody @Valid BarcodeSKURequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public BarcodeSKUResponse update(@PathVariable Long id,
            @RequestBody @Valid BarcodeSKURequest request) {
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
