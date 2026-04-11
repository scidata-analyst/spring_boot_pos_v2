package com.example.pos.controllers.Promotions;

import com.example.pos.dtos.request.Promotions.CouponCodesRequest;
import com.example.pos.dtos.response.Promotions.CouponCodesResponse;
import com.example.pos.services.Promotions.CouponCodesService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: CouponCodes
 * =====================================================
 *
 * Provides standard REST APIs for CouponCodes.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Promotions/CouponCodes")
public class CouponCodesController {

    @Autowired
    private CouponCodesService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<CouponCodesResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<CouponCodesResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public CouponCodesResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public CouponCodesResponse create(@RequestBody @Valid CouponCodesRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public CouponCodesResponse update(@PathVariable Long id,
            @RequestBody @Valid CouponCodesRequest request) {
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
