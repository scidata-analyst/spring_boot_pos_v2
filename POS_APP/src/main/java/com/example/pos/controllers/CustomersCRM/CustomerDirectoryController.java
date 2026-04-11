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
 * Provides standard CRUD APIs for CustomerDirectory.
 * All responses are returned using CustomerDirectoryResponse DTO.
 *
 * Endpoints:
 * - GET    /api/CustomersCRM/CustomerDirectory
 * - GET    /api/CustomersCRM/CustomerDirectory/{id}
 * - POST   /api/CustomersCRM/CustomerDirectory
 * - PUT    /api/CustomersCRM/CustomerDirectory/{id}
 * - DELETE /api/CustomersCRM/CustomerDirectory/{id}
 */
@RestController
@RequestMapping("/api/CustomersCRM/CustomerDirectory")
public class CustomerDirectoryController {

    @Autowired
    private CustomerDirectoryService service;

    /**
     * Retrieve all CustomerDirectory records.
     *
     * @return List of CustomerDirectoryResponse
     */
    @GetMapping
    public List<CustomerDirectoryResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single CustomerDirectory by ID.
     *
     * @param id ID of the CustomerDirectory
     * @return CustomerDirectoryResponse
     */
    @GetMapping("/{id}")
    public CustomerDirectoryResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new CustomerDirectory record.
     *
     * @param request request DTO
     * @return created CustomerDirectoryResponse
     */
    @PostMapping
    public CustomerDirectoryResponse create(@RequestBody @Valid CustomerDirectoryRequest request) {
        return service.create(request);
    }

    /**
     * Update existing CustomerDirectory record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated CustomerDirectoryResponse
     */
    @PutMapping("/{id}")
    public CustomerDirectoryResponse update(@PathVariable Long id,
                                         @RequestBody @Valid CustomerDirectoryRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a CustomerDirectory record.
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
