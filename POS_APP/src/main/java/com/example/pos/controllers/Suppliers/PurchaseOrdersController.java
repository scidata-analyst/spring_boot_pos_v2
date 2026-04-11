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
 * Provides standard CRUD APIs for PurchaseOrders.
 * All responses are returned using PurchaseOrdersResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Suppliers/PurchaseOrders
 * - GET    /api/Suppliers/PurchaseOrders/{id}
 * - POST   /api/Suppliers/PurchaseOrders
 * - PUT    /api/Suppliers/PurchaseOrders/{id}
 * - DELETE /api/Suppliers/PurchaseOrders/{id}
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
     * Retrieve a single PurchaseOrders by ID.
     *
     * @param id ID of the PurchaseOrders
     * @return PurchaseOrdersResponse
     */
    @GetMapping("/{id}")
    public PurchaseOrdersResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new PurchaseOrders record.
     *
     * @param request request DTO
     * @return created PurchaseOrdersResponse
     */
    @PostMapping
    public PurchaseOrdersResponse create(@RequestBody @Valid PurchaseOrdersRequest request) {
        return service.create(request);
    }

    /**
     * Update existing PurchaseOrders record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated PurchaseOrdersResponse
     */
    @PutMapping("/{id}")
    public PurchaseOrdersResponse update(@PathVariable Long id,
                                         @RequestBody @Valid PurchaseOrdersRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a PurchaseOrders record.
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
