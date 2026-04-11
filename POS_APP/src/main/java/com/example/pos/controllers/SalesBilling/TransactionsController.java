package com.example.pos.controllers.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.TransactionsRequest;
import com.example.pos.dtos.response.SalesBilling.TransactionsResponse;
import com.example.pos.services.SalesBilling.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: Transactions
 * =====================================================
 *
 * Provides standard CRUD APIs for Transactions.
 * All responses are returned using TransactionsResponse DTO.
 *
 * Endpoints:
 * - GET    /api/SalesBilling/Transactions
 * - GET    /api/SalesBilling/Transactions/{id}
 * - POST   /api/SalesBilling/Transactions
 * - PUT    /api/SalesBilling/Transactions/{id}
 * - DELETE /api/SalesBilling/Transactions/{id}
 */
@RestController
@RequestMapping("/api/SalesBilling/Transactions")
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
     * Retrieve a single Transactions by ID.
     *
     * @param id ID of the Transactions
     * @return TransactionsResponse
     */
    @GetMapping("/{id}")
    public TransactionsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new Transactions record.
     *
     * @param request request DTO
     * @return created TransactionsResponse
     */
    @PostMapping
    public TransactionsResponse create(@RequestBody @Valid TransactionsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing Transactions record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated TransactionsResponse
     */
    @PutMapping("/{id}")
    public TransactionsResponse update(@PathVariable Long id,
                                         @RequestBody @Valid TransactionsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Transactions record.
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
