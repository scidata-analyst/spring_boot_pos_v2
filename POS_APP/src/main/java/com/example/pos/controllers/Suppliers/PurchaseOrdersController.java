package com.example.pos.controllers.Suppliers;

import com.example.pos.dtos.request.Suppliers.PurchaseOrdersRequest;
import com.example.pos.dtos.response.Suppliers.PurchaseOrdersResponse;
import com.example.pos.services.Suppliers.PurchaseOrdersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing PurchaseOrders operations.
 * Provides standard CRUD endpoints for PurchaseOrders.
 * All responses are returned using PurchaseOrdersResponse DTO.
 */
@RestController
@RequestMapping("/api/Suppliers/PurchaseOrders")
public class PurchaseOrdersController {

    @Autowired
    private PurchaseOrdersService service;

    /**
     * Retrieve all PurchaseOrders records.
     * 
     * @return List of PurchaseOrdersResponse
     */
    @GetMapping
    public List<PurchaseOrdersResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single PurchaseOrders by its ID.
     * 
     * @param id ID of the PurchaseOrders
     * @return PurchaseOrdersResponse object
     */
    @GetMapping("/{id}")
    public PurchaseOrdersResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new PurchaseOrders record.
     * 
     * @param request DTO containing the PurchaseOrders data
     * @return Created PurchaseOrdersResponse
     */
    @PostMapping
    public PurchaseOrdersResponse create(@RequestBody @Valid PurchaseOrdersRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing PurchaseOrders by its ID.
     * 
     * @param id      ID of the PurchaseOrders to update
     * @param request DTO containing updated data
     * @return Updated PurchaseOrdersResponse
     */
    @PutMapping("/{id}")
    public PurchaseOrdersResponse update(@PathVariable Long id, @RequestBody @Valid PurchaseOrdersRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a PurchaseOrders by its ID.
     * 
     * @param id ID of the PurchaseOrders to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
