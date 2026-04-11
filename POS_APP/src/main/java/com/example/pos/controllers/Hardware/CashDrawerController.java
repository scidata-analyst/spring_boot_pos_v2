package com.example.pos.controllers.Hardware;

import com.example.pos.dtos.request.Hardware.CashDrawerRequest;
import com.example.pos.dtos.response.Hardware.CashDrawerResponse;
import com.example.pos.services.Hardware.CashDrawerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing CashDrawer operations.
 * Provides standard CRUD endpoints for CashDrawer.
 * All responses are returned using CashDrawerResponse DTO.
 */
@RestController
@RequestMapping("/api/Hardware/CashDrawer")
public class CashDrawerController {

    @Autowired
    private CashDrawerService service;

    /**
     * Retrieve all CashDrawer records.
     * 
     * @return List of CashDrawerResponse
     */
    @GetMapping
    public List<CashDrawerResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single CashDrawer by its ID.
     * 
     * @param id ID of the CashDrawer
     * @return CashDrawerResponse object
     */
    @GetMapping("/{id}")
    public CashDrawerResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new CashDrawer record.
     * 
     * @param request DTO containing the CashDrawer data
     * @return Created CashDrawerResponse
     */
    @PostMapping
    public CashDrawerResponse create(@RequestBody @Valid CashDrawerRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing CashDrawer by its ID.
     * 
     * @param id      ID of the CashDrawer to update
     * @param request DTO containing updated data
     * @return Updated CashDrawerResponse
     */
    @PutMapping("/{id}")
    public CashDrawerResponse update(@PathVariable Long id, @RequestBody @Valid CashDrawerRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a CashDrawer by its ID.
     * 
     * @param id ID of the CashDrawer to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
