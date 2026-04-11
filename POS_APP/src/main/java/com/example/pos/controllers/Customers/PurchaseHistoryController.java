package com.example.pos.controllers.Customers;

import com.example.pos.dtos.request.Customers.PurchaseHistoryRequest;
import com.example.pos.dtos.response.Customers.PurchaseHistoryResponse;
import com.example.pos.services.Customers.PurchaseHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing PurchaseHistory operations.
 * Provides standard CRUD endpoints for PurchaseHistory.
 * All responses are returned using PurchaseHistoryResponse DTO.
 */
@RestController
@RequestMapping("/api/Customers/PurchaseHistory")
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService service;

    /**
     * Retrieve all PurchaseHistory records.
     * 
     * @return List of PurchaseHistoryResponse
     */
    @GetMapping
    public List<PurchaseHistoryResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single PurchaseHistory by its ID.
     * 
     * @param id ID of the PurchaseHistory
     * @return PurchaseHistoryResponse object
     */
    @GetMapping("/{id}")
    public PurchaseHistoryResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new PurchaseHistory record.
     * 
     * @param request DTO containing the PurchaseHistory data
     * @return Created PurchaseHistoryResponse
     */
    @PostMapping
    public PurchaseHistoryResponse create(@RequestBody @Valid PurchaseHistoryRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing PurchaseHistory by its ID.
     * 
     * @param id      ID of the PurchaseHistory to update
     * @param request DTO containing updated data
     * @return Updated PurchaseHistoryResponse
     */
    @PutMapping("/{id}")
    public PurchaseHistoryResponse update(@PathVariable Long id, @RequestBody @Valid PurchaseHistoryRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a PurchaseHistory by its ID.
     * 
     * @param id ID of the PurchaseHistory to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
