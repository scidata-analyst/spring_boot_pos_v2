package com.example.pos.controllers.Sales;

import com.example.pos.dtos.request.Sales.InvoicesRequest;
import com.example.pos.dtos.response.Sales.InvoicesResponse;
import com.example.pos.services.Sales.InvoicesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Invoices operations.
 * Provides standard CRUD endpoints for Invoices.
 * All responses are returned using InvoicesResponse DTO.
 */
@RestController
@RequestMapping(""/api/Sales/Invoices"")
public class InvoicesController {

    @Autowired
    private InvoicesService service;

    /**
     * Retrieve all Invoices records.
     * @return List of InvoicesResponse
     */
    @GetMapping
    public List<InvoicesResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Invoices by its ID.
     * @param id ID of the Invoices
     * @return InvoicesResponse object
     */
    @GetMapping(""/{id}"")
    public InvoicesResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Invoices record.
     * @param request DTO containing the Invoices data
     * @return Created InvoicesResponse
     */
    @PostMapping
    public InvoicesResponse create(@RequestBody @Valid InvoicesRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Invoices by its ID.
     * @param id ID of the Invoices to update
     * @param request DTO containing updated data
     * @return Updated InvoicesResponse
     */
    @PutMapping(""/{id}"")
    public InvoicesResponse update(@PathVariable Long id, @RequestBody @Valid InvoicesRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Invoices by its ID.
     * @param id ID of the Invoices to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
