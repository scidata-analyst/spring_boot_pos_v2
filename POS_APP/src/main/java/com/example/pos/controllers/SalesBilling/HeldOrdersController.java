package com.example.pos.controllers.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.HeldOrdersRequest;
import com.example.pos.dtos.response.SalesBilling.HeldOrdersResponse;
import com.example.pos.services.SalesBilling.HeldOrdersService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * =====================================================
 * REST Controller: HeldOrders
 * =====================================================
 *
 * Provides standard REST APIs for HeldOrders.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/SalesBilling/HeldOrders")
public class HeldOrdersController {

    @Autowired
    private HeldOrdersService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<HeldOrdersResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public Page<HeldOrdersResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public HeldOrdersResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public HeldOrdersResponse create(@RequestBody @Valid HeldOrdersRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public HeldOrdersResponse update(@PathVariable Long id,
            @RequestBody @Valid HeldOrdersRequest request) {
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
