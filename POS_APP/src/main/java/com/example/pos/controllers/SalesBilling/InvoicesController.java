package com.example.pos.controllers.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.InvoicesRequest;
import com.example.pos.dtos.response.SalesBilling.InvoicesResponse;
import com.example.pos.services.SalesBilling.InvoicesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: Invoices
 * =====================================================
 *
 * Provides standard CRUD APIs for Invoices.
 * All responses are returned using InvoicesResponse DTO.
 *
 * Endpoints:
 * - GET    /api/SalesBilling/Invoices
 * - GET    /api/SalesBilling/Invoices/{id}
 * - POST   /api/SalesBilling/Invoices
 * - PUT    /api/SalesBilling/Invoices/{id}
 * - DELETE /api/SalesBilling/Invoices/{id}
 */
@RestController
@RequestMapping("/api/SalesBilling/Invoices")
public class InvoicesController {

    @Autowired
    private InvoicesService service;

    /**
     * Retrieve all Invoices records.
     *
     * @return List of InvoicesResponse
     */
    @GetMapping
    public List<InvoicesResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Invoices by ID.
     *
     * @param id ID of the Invoices
     * @return InvoicesResponse
     */
    @GetMapping("/{id}")
    public InvoicesResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new Invoices record.
     *
     * @param request request DTO
     * @return created InvoicesResponse
     */
    @PostMapping
    public InvoicesResponse create(@RequestBody @Valid InvoicesRequest request) {
        return service.create(request);
    }

    /**
     * Update existing Invoices record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated InvoicesResponse
     */
    @PutMapping("/{id}")
    public InvoicesResponse update(@PathVariable Long id,
                                         @RequestBody @Valid InvoicesRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Invoices record.
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
