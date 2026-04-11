package com.example.pos.controllers.CustomersCRM;

import com.example.pos.dtos.request.CustomersCRM.PurchaseHistoryRequest;
import com.example.pos.dtos.response.CustomersCRM.PurchaseHistoryResponse;
import com.example.pos.services.CustomersCRM.PurchaseHistoryService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: PurchaseHistory
 * =====================================================
 *
 * Provides standard REST APIs for PurchaseHistory.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/CustomersCRM/PurchaseHistory")
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<PurchaseHistoryResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<PurchaseHistoryResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public PurchaseHistoryResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public PurchaseHistoryResponse create(@RequestBody @Valid PurchaseHistoryRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public PurchaseHistoryResponse update(@PathVariable Long id,
            @RequestBody @Valid PurchaseHistoryRequest request) {
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
