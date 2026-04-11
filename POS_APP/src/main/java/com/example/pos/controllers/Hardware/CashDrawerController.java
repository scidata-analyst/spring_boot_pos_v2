package com.example.pos.controllers.Hardware;

import com.example.pos.dtos.request.Hardware.CashDrawerRequest;
import com.example.pos.dtos.response.Hardware.CashDrawerResponse;
import com.example.pos.services.Hardware.CashDrawerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: CashDrawer
 * =====================================================
 *
 * Provides standard CRUD APIs for CashDrawer.
 * All responses are returned using CashDrawerResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Hardware/CashDrawer
 * - GET    /api/Hardware/CashDrawer/{id}
 * - POST   /api/Hardware/CashDrawer
 * - PUT    /api/Hardware/CashDrawer/{id}
 * - DELETE /api/Hardware/CashDrawer/{id}
 */
@RestController
@RequestMapping("/api/Hardware/CashDrawer")
public class CashDrawerController {

    @Autowired
    private CashDrawerService service;

    /**
     * Retrieve all CashDrawer records.
     *
     * @return List of CashDrawerResponse
     */
    @GetMapping
    public List<CashDrawerResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single CashDrawer by ID.
     *
     * @param id ID of the CashDrawer
     * @return CashDrawerResponse
     */
    @GetMapping("/{id}")
    public CashDrawerResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new CashDrawer record.
     *
     * @param request request DTO
     * @return created CashDrawerResponse
     */
    @PostMapping
    public CashDrawerResponse create(@RequestBody @Valid CashDrawerRequest request) {
        return service.create(request);
    }

    /**
     * Update existing CashDrawer record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated CashDrawerResponse
     */
    @PutMapping("/{id}")
    public CashDrawerResponse update(@PathVariable Long id,
                                         @RequestBody @Valid CashDrawerRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a CashDrawer record.
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
