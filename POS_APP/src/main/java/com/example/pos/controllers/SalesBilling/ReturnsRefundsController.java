package com.example.pos.controllers.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.ReturnsRefundsRequest;
import com.example.pos.dtos.response.SalesBilling.ReturnsRefundsResponse;
import com.example.pos.services.SalesBilling.ReturnsRefundsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * =====================================================
 * REST Controller: ReturnsRefunds
 * =====================================================
 *
 * Provides standard REST APIs for ReturnsRefunds.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/SalesBilling/ReturnsRefunds")
public class ReturnsRefundsController {

    @Autowired
    private ReturnsRefundsService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<ReturnsRefundsResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public Page<ReturnsRefundsResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public ReturnsRefundsResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public ReturnsRefundsResponse create(@RequestBody @Valid ReturnsRefundsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public ReturnsRefundsResponse update(@PathVariable Long id,
            @RequestBody @Valid ReturnsRefundsRequest request) {
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
