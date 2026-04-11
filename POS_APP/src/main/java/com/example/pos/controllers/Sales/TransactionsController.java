package com.example.pos.controllers.Sales;

import com.example.pos.dtos.request.Sales.TransactionsRequest;
import com.example.pos.dtos.response.Sales.TransactionsResponse;
import com.example.pos.services.Sales.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Transactions operations.
 * Provides standard CRUD endpoints for Transactions.
 * All responses are returned using TransactionsResponse DTO.
 */
@RestController
@RequestMapping("/api/Sales/Transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService service;

    /**
     * Retrieve all Transactions records.
     * 
     * @return List of TransactionsResponse
     */
    @GetMapping
    public List<TransactionsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Transactions by its ID.
     * 
     * @param id ID of the Transactions
     * @return TransactionsResponse object
     */
    @GetMapping("/{id}")
    public TransactionsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new Transactions record.
     * 
     * @param request DTO containing the Transactions data
     * @return Created TransactionsResponse
     */
    @PostMapping
    public TransactionsResponse create(@RequestBody @Valid TransactionsRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Transactions by its ID.
     * 
     * @param id      ID of the Transactions to update
     * @param request DTO containing updated data
     * @return Updated TransactionsResponse
     */
    @PutMapping("/{id}")
    public TransactionsResponse update(@PathVariable Long id, @RequestBody @Valid TransactionsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Transactions by its ID.
     * 
     * @param id ID of the Transactions to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
