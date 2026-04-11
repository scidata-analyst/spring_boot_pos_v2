package com.example.pos.controllers.CustomersCRM;

import com.example.pos.dtos.request.CustomersCRM.CustomerDirectoryRequest;
import com.example.pos.dtos.response.CustomersCRM.CustomerDirectoryResponse;
import com.example.pos.services.CustomersCRM.CustomerDirectoryService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: CustomerDirectory
 * =====================================================
 *
 * Provides standard REST APIs for CustomerDirectory.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/CustomersCRM/CustomerDirectory")
public class CustomerDirectoryController {

    @Autowired
    private CustomerDirectoryService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<CustomerDirectoryResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<CustomerDirectoryResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public CustomerDirectoryResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public CustomerDirectoryResponse create(@RequestBody @Valid CustomerDirectoryRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public CustomerDirectoryResponse update(@PathVariable Long id,
            @RequestBody @Valid CustomerDirectoryRequest request) {
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
