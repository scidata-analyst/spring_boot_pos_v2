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
 * Provides standard CRUD APIs for PurchaseHistory.
 * All responses are returned using PurchaseHistoryResponse DTO.
 *
 * Endpoints:
 * - GET    /api/CustomersCRM/PurchaseHistory
 * - GET    /api/CustomersCRM/PurchaseHistory/{id}
 * - POST   /api/CustomersCRM/PurchaseHistory
 * - PUT    /api/CustomersCRM/PurchaseHistory/{id}
 * - DELETE /api/CustomersCRM/PurchaseHistory/{id}
 */
@RestController
@RequestMapping("/api/CustomersCRM/PurchaseHistory")
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService service;

    /**
     * Retrieve all PurchaseHistory records.
     *
     * @return List of PurchaseHistoryResponse
     */
    @GetMapping
    public List<PurchaseHistoryResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single PurchaseHistory by ID.
     *
     * @param id ID of the PurchaseHistory
     * @return PurchaseHistoryResponse
     */
    @GetMapping("/{id}")
    public PurchaseHistoryResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new PurchaseHistory record.
     *
     * @param request request DTO
     * @return created PurchaseHistoryResponse
     */
    @PostMapping
    public PurchaseHistoryResponse create(@RequestBody @Valid PurchaseHistoryRequest request) {
        return service.create(request);
    }

    /**
     * Update existing PurchaseHistory record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated PurchaseHistoryResponse
     */
    @PutMapping("/{id}")
    public PurchaseHistoryResponse update(@PathVariable Long id,
                                         @RequestBody @Valid PurchaseHistoryRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a PurchaseHistory record.
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
