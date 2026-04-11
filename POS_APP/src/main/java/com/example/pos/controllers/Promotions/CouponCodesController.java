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
 * Provides standard CRUD APIs for CouponCodes.
 * All responses are returned using CouponCodesResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Promotions/CouponCodes
 * - GET    /api/Promotions/CouponCodes/{id}
 * - POST   /api/Promotions/CouponCodes
 * - PUT    /api/Promotions/CouponCodes/{id}
 * - DELETE /api/Promotions/CouponCodes/{id}
 */
@RestController
@RequestMapping("/api/Promotions/CouponCodes")
public class CouponCodesController {

    @Autowired
    private CouponCodesService service;

    /**
     * Retrieve all CouponCodes records.
     *
     * @return List of CouponCodesResponse
     */
    @GetMapping
    public List<CouponCodesResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single CouponCodes by ID.
     *
     * @param id ID of the CouponCodes
     * @return CouponCodesResponse
     */
    @GetMapping("/{id}")
    public CouponCodesResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new CouponCodes record.
     *
     * @param request request DTO
     * @return created CouponCodesResponse
     */
    @PostMapping
    public CouponCodesResponse create(@RequestBody @Valid CouponCodesRequest request) {
        return service.create(request);
    }

    /**
     * Update existing CouponCodes record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated CouponCodesResponse
     */
    @PutMapping("/{id}")
    public CouponCodesResponse update(@PathVariable Long id,
                                         @RequestBody @Valid CouponCodesRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a CouponCodes record.
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
