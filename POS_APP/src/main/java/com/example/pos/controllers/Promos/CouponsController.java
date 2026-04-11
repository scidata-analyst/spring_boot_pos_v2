package com.example.pos.controllers.Promos;

import com.example.pos.dtos.request.Promos.CouponsRequest;
import com.example.pos.dtos.response.Promos.CouponsResponse;
import com.example.pos.services.Promos.CouponsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Coupons operations.
 * Provides standard CRUD endpoints for Coupons.
 * All responses are returned using CouponsResponse DTO.
 */
@RestController
@RequestMapping("/api/Promos/Coupons")
public class CouponsController {

    @Autowired
    private CouponsService service;

    /**
     * Retrieve all Coupons records.
     * 
     * @return List of CouponsResponse
     */
    @GetMapping
    public List<CouponsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Coupons by its ID.
     * 
     * @param id ID of the Coupons
     * @return CouponsResponse object
     */
    @GetMapping("/{id}")
    public CouponsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new Coupons record.
     * 
     * @param request DTO containing the Coupons data
     * @return Created CouponsResponse
     */
    @PostMapping
    public CouponsResponse create(@RequestBody @Valid CouponsRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Coupons by its ID.
     * 
     * @param id      ID of the Coupons to update
     * @param request DTO containing updated data
     * @return Updated CouponsResponse
     */
    @PutMapping("/{id}")
    public CouponsResponse update(@PathVariable Long id, @RequestBody @Valid CouponsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Coupons by its ID.
     * 
     * @param id ID of the Coupons to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
