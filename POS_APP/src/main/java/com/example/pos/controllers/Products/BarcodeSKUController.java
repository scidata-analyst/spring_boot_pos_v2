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
 * Provides standard CRUD APIs for BarcodeSKU.
 * All responses are returned using BarcodeSKUResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Products/BarcodeSKU
 * - GET    /api/Products/BarcodeSKU/{id}
 * - POST   /api/Products/BarcodeSKU
 * - PUT    /api/Products/BarcodeSKU/{id}
 * - DELETE /api/Products/BarcodeSKU/{id}
 */
@RestController
@RequestMapping("/api/Products/BarcodeSKU")
public class BarcodeSKUController {

    @Autowired
    private BarcodeSKUService service;

    /**
     * Retrieve all BarcodeSKU records.
     *
     * @return List of BarcodeSKUResponse
     */
    @GetMapping
    public List<BarcodeSKUResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single BarcodeSKU by ID.
     *
     * @param id ID of the BarcodeSKU
     * @return BarcodeSKUResponse
     */
    @GetMapping("/{id}")
    public BarcodeSKUResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new BarcodeSKU record.
     *
     * @param request request DTO
     * @return created BarcodeSKUResponse
     */
    @PostMapping
    public BarcodeSKUResponse create(@RequestBody @Valid BarcodeSKURequest request) {
        return service.create(request);
    }

    /**
     * Update existing BarcodeSKU record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated BarcodeSKUResponse
     */
    @PutMapping("/{id}")
    public BarcodeSKUResponse update(@PathVariable Long id,
                                         @RequestBody @Valid BarcodeSKURequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a BarcodeSKU record.
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
