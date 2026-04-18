package com.example.pos.controllers.Suppliers;

import com.example.pos.dtos.request.Suppliers.SupplierDirectoryRequest;
import com.example.pos.dtos.response.Suppliers.SupplierDirectoryResponse;
import com.example.pos.services.Suppliers.SupplierDirectoryService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * =====================================================
 * REST Controller: SupplierDirectory
 * =====================================================
 *
 * Provides standard REST APIs for SupplierDirectory.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Suppliers/SupplierDirectory")
public class SupplierDirectoryController {

    @Autowired
    private SupplierDirectoryService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<SupplierDirectoryResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public Page<SupplierDirectoryResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public SupplierDirectoryResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public SupplierDirectoryResponse create(@RequestBody @Valid SupplierDirectoryRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public SupplierDirectoryResponse update(@PathVariable Long id,
            @RequestBody @Valid SupplierDirectoryRequest request) {
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
