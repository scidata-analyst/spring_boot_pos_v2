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
 * Provides standard CRUD APIs for CashRegister.
 * All responses are returned using CashRegisterResponse DTO.
 *
 * Endpoints:
 * - GET    /api/PaymentAccounting/CashRegister
 * - GET    /api/PaymentAccounting/CashRegister/{id}
 * - POST   /api/PaymentAccounting/CashRegister
 * - PUT    /api/PaymentAccounting/CashRegister/{id}
 * - DELETE /api/PaymentAccounting/CashRegister/{id}
 */
@RestController
@RequestMapping("/api/PaymentAccounting/CashRegister")
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
     * Retrieve a single CashRegister by ID.
     *
     * @param id ID of the CashRegister
     * @return CashRegisterResponse
     */
    @GetMapping("/{id}")
    public CashRegisterResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new CashRegister record.
     *
     * @param request request DTO
     * @return created CashRegisterResponse
     */
    @PostMapping
    public CashRegisterResponse create(@RequestBody @Valid CashRegisterRequest request) {
        return service.create(request);
    }

    /**
     * Update existing CashRegister record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated CashRegisterResponse
     */
    @PutMapping("/{id}")
    public CashRegisterResponse update(@PathVariable Long id,
                                         @RequestBody @Valid CashRegisterRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a CashRegister record.
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
