package com.example.pos.controllers.Accounting;

import com.example.pos.dtos.request.Accounting.CashRegisterRequest;
import com.example.pos.dtos.response.Accounting.CashRegisterResponse;
import com.example.pos.services.Accounting.CashRegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing CashRegister operations.
 * Provides standard CRUD endpoints for CashRegister.
 * All responses are returned using CashRegisterResponse DTO.
 */
@RestController
@RequestMapping("/api/Accounting/CashRegister")
public class CashRegisterController {

    @Autowired
    private CashRegisterService service;

    /**
     * Retrieve all CashRegister records.
     * 
     * @return List of CashRegisterResponse
     */
    @GetMapping
    public List<CashRegisterResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single CashRegister by its ID.
     * 
     * @param id ID of the CashRegister
     * @return CashRegisterResponse object
     */
    @GetMapping("/{id}")
    public CashRegisterResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new CashRegister record.
     * 
     * @param request DTO containing the CashRegister data
     * @return Created CashRegisterResponse
     */
    @PostMapping
    public CashRegisterResponse create(@RequestBody @Valid CashRegisterRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing CashRegister by its ID.
     * 
     * @param id      ID of the CashRegister to update
     * @param request DTO containing updated data
     * @return Updated CashRegisterResponse
     */
    @PutMapping("/{id}")
    public CashRegisterResponse update(@PathVariable Long id, @RequestBody @Valid CashRegisterRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a CashRegister by its ID.
     * 
     * @param id ID of the CashRegister to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
