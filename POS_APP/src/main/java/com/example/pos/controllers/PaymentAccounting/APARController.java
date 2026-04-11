package com.example.pos.controllers.PaymentAccounting;

import com.example.pos.dtos.request.PaymentAccounting.APARRequest;
import com.example.pos.dtos.response.PaymentAccounting.APARResponse;
import com.example.pos.services.PaymentAccounting.APARService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: APAR
 * =====================================================
 *
 * Provides standard CRUD APIs for APAR.
 * All responses are returned using APARResponse DTO.
 *
 * Endpoints:
 * - GET    /api/PaymentAccounting/APAR
 * - GET    /api/PaymentAccounting/APAR/{id}
 * - POST   /api/PaymentAccounting/APAR
 * - PUT    /api/PaymentAccounting/APAR/{id}
 * - DELETE /api/PaymentAccounting/APAR/{id}
 */
@RestController
@RequestMapping("/api/PaymentAccounting/APAR")
public class APARController {

    @Autowired
    private APARService service;

    /**
     * Retrieve all APAR records.
     *
     * @return List of APARResponse
     */
    @GetMapping
    public List<APARResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single APAR by ID.
     *
     * @param id ID of the APAR
     * @return APARResponse
     */
    @GetMapping("/{id}")
    public APARResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new APAR record.
     *
     * @param request request DTO
     * @return created APARResponse
     */
    @PostMapping
    public APARResponse create(@RequestBody @Valid APARRequest request) {
        return service.create(request);
    }

    /**
     * Update existing APAR record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated APARResponse
     */
    @PutMapping("/{id}")
    public APARResponse update(@PathVariable Long id,
                                         @RequestBody @Valid APARRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a APAR record.
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
