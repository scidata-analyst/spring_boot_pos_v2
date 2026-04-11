package com.example.pos.controllers.PaymentAccounting;

import com.example.pos.dtos.request.PaymentAccounting.CashRegisterRequest;
import com.example.pos.dtos.response.PaymentAccounting.CashRegisterResponse;
import com.example.pos.services.PaymentAccounting.CashRegisterService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: CashRegister
 * =====================================================
 *
 * Provides standard REST APIs for CashRegister.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/PaymentAccounting/CashRegister")
public class CashRegisterController {

    @Autowired
    private CashRegisterService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<CashRegisterResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<CashRegisterResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public CashRegisterResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public CashRegisterResponse create(@RequestBody @Valid CashRegisterRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public CashRegisterResponse update(@PathVariable Long id,
            @RequestBody @Valid CashRegisterRequest request) {
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
