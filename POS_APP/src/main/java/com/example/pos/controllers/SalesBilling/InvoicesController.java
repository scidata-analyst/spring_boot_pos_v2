package com.example.pos.controllers.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.InvoicesRequest;
import com.example.pos.dtos.response.SalesBilling.InvoicesResponse;
import com.example.pos.services.SalesBilling.InvoicesService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * =====================================================
 * REST Controller: Invoices
 * =====================================================
 *
 * Provides standard REST APIs for Invoices.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/SalesBilling/Invoices")
public class InvoicesController {

    @Autowired
    private InvoicesService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<InvoicesResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public Page<InvoicesResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public InvoicesResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public InvoicesResponse create(@RequestBody @Valid InvoicesRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public InvoicesResponse update(@PathVariable Long id,
            @RequestBody @Valid InvoicesRequest request) {
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
