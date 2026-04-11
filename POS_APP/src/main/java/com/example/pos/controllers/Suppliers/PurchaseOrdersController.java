package com.example.pos.controllers.Suppliers;

import com.example.pos.dtos.request.Suppliers.PurchaseOrdersRequest;
import com.example.pos.dtos.response.Suppliers.PurchaseOrdersResponse;
import com.example.pos.services.Suppliers.PurchaseOrdersService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: PurchaseOrders
 * =====================================================
 *
 * Provides standard REST APIs for PurchaseOrders.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Suppliers/PurchaseOrders")
public class PurchaseOrdersController {

    @Autowired
    private PurchaseOrdersService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<PurchaseOrdersResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<PurchaseOrdersResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public PurchaseOrdersResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public PurchaseOrdersResponse create(@RequestBody @Valid PurchaseOrdersRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public PurchaseOrdersResponse update(@PathVariable Long id,
            @RequestBody @Valid PurchaseOrdersRequest request) {
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
