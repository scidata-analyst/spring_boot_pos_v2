package com.example.pos.controllers.Products;

import com.example.pos.dtos.request.Products.BarcodesRequest;
import com.example.pos.dtos.response.Products.BarcodesResponse;
import com.example.pos.services.Products.BarcodesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Barcodes operations.
 * Provides standard CRUD endpoints for Barcodes.
 * All responses are returned using BarcodesResponse DTO.
 */
@RestController
@RequestMapping("/api/Products/Barcodes")
public class BarcodesController {

    @Autowired
    private BarcodesService service;

    /**
     * Retrieve all Barcodes records.
     * 
     * @return List of BarcodesResponse
     */
    @GetMapping
    public List<BarcodesResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Barcodes by its ID.
     * 
     * @param id ID of the Barcodes
     * @return BarcodesResponse object
     */
    @GetMapping("/{id}")
    public BarcodesResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Barcodes record.
     * 
     * @param request DTO containing the Barcodes data
     * @return Created BarcodesResponse
     */
    @PostMapping
    public BarcodesResponse create(@RequestBody @Valid BarcodesRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Barcodes by its ID.
     * 
     * @param id      ID of the Barcodes to update
     * @param request DTO containing updated data
     * @return Updated BarcodesResponse
     */
    @PutMapping("/{id}")
    public BarcodesResponse update(@PathVariable Long id, @RequestBody @Valid BarcodesRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Barcodes by its ID.
     * 
     * @param id ID of the Barcodes to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
