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
 * Provides standard REST APIs for CashDrawer.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Hardware/CashDrawer")
public class CashDrawerController {

    @Autowired
    private CashDrawerService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<CashDrawerResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<CashDrawerResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public CashDrawerResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public CashDrawerResponse create(@RequestBody @Valid CashDrawerRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public CashDrawerResponse update(@PathVariable Long id,
            @RequestBody @Valid CashDrawerRequest request) {
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
