package com.example.pos.controllers.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.TransactionsRequest;
import com.example.pos.dtos.response.SalesBilling.TransactionsResponse;
import com.example.pos.services.SalesBilling.TransactionsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * =====================================================
 * REST Controller: Transactions
 * =====================================================
 *
 * Provides standard REST APIs for Transactions.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/SalesBilling/Transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<TransactionsResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public Page<TransactionsResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public TransactionsResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public TransactionsResponse create(@RequestBody @Valid TransactionsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public TransactionsResponse update(@PathVariable Long id,
            @RequestBody @Valid TransactionsRequest request) {
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
