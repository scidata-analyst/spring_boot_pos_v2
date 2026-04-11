package com.example.pos.controllers.Suppliers;

import com.example.pos.dtos.request.Suppliers.SupplierDirectoryRequest;
import com.example.pos.dtos.response.Suppliers.SupplierDirectoryResponse;
import com.example.pos.services.Suppliers.SupplierDirectoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: SupplierDirectory
 * =====================================================
 *
 * Provides standard CRUD APIs for SupplierDirectory.
 * All responses are returned using SupplierDirectoryResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Suppliers/SupplierDirectory
 * - GET    /api/Suppliers/SupplierDirectory/{id}
 * - POST   /api/Suppliers/SupplierDirectory
 * - PUT    /api/Suppliers/SupplierDirectory/{id}
 * - DELETE /api/Suppliers/SupplierDirectory/{id}
 */
@RestController
@RequestMapping("/api/Suppliers/SupplierDirectory")
public class SupplierDirectoryController {

    @Autowired
    private SupplierDirectoryService service;

    /**
     * Retrieve all SupplierDirectory records.
     *
     * @return List of SupplierDirectoryResponse
     */
    @GetMapping
    public List<SupplierDirectoryResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single SupplierDirectory by ID.
     *
     * @param id ID of the SupplierDirectory
     * @return SupplierDirectoryResponse
     */
    @GetMapping("/{id}")
    public SupplierDirectoryResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new SupplierDirectory record.
     *
     * @param request request DTO
     * @return created SupplierDirectoryResponse
     */
    @PostMapping
    public SupplierDirectoryResponse create(@RequestBody @Valid SupplierDirectoryRequest request) {
        return service.create(request);
    }

    /**
     * Update existing SupplierDirectory record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated SupplierDirectoryResponse
     */
    @PutMapping("/{id}")
    public SupplierDirectoryResponse update(@PathVariable Long id,
                                         @RequestBody @Valid SupplierDirectoryRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a SupplierDirectory record.
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
