package com.example.pos.controllers.Promos;

import com.example.pos.dtos.request.Promos.OffersRequest;
import com.example.pos.dtos.response.Promos.OffersResponse;
import com.example.pos.services.Promos.OffersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Offers operations.
 * Provides standard CRUD endpoints for Offers.
 * All responses are returned using OffersResponse DTO.
 */
@RestController
@RequestMapping("/api/Promos/Offers")
public class OffersController {

    @Autowired
    private OffersService service;

    /**
     * Retrieve all Offers records.
     * 
     * @return List of OffersResponse
     */
    @GetMapping
    public List<OffersResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Offers by its ID.
     * 
     * @param id ID of the Offers
     * @return OffersResponse object
     */
    @GetMapping("/{id}")
    public OffersResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new Offers record.
     * 
     * @param request DTO containing the Offers data
     * @return Created OffersResponse
     */
    @PostMapping
    public OffersResponse create(@RequestBody @Valid OffersRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Offers by its ID.
     * 
     * @param id      ID of the Offers to update
     * @param request DTO containing updated data
     * @return Updated OffersResponse
     */
    @PutMapping("/{id}")
    public OffersResponse update(@PathVariable Long id, @RequestBody @Valid OffersRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Offers by its ID.
     * 
     * @param id ID of the Offers to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
