package com.example.pos.controllers.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.ReturnsRefundsRequest;
import com.example.pos.dtos.response.SalesBilling.ReturnsRefundsResponse;
import com.example.pos.services.SalesBilling.ReturnsRefundsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: ReturnsRefunds
 * =====================================================
 *
 * Provides standard CRUD APIs for ReturnsRefunds.
 * All responses are returned using ReturnsRefundsResponse DTO.
 *
 * Endpoints:
 * - GET    /api/SalesBilling/ReturnsRefunds
 * - GET    /api/SalesBilling/ReturnsRefunds/{id}
 * - POST   /api/SalesBilling/ReturnsRefunds
 * - PUT    /api/SalesBilling/ReturnsRefunds/{id}
 * - DELETE /api/SalesBilling/ReturnsRefunds/{id}
 */
@RestController
@RequestMapping("/api/SalesBilling/ReturnsRefunds")
public class ReturnsRefundsController {

    @Autowired
    private ReturnsRefundsService service;

    /**
     * Retrieve all ReturnsRefunds records.
     *
     * @return List of ReturnsRefundsResponse
     */
    @GetMapping
    public List<ReturnsRefundsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single ReturnsRefunds by ID.
     *
     * @param id ID of the ReturnsRefunds
     * @return ReturnsRefundsResponse
     */
    @GetMapping("/{id}")
    public ReturnsRefundsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new ReturnsRefunds record.
     *
     * @param request request DTO
     * @return created ReturnsRefundsResponse
     */
    @PostMapping
    public ReturnsRefundsResponse create(@RequestBody @Valid ReturnsRefundsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing ReturnsRefunds record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated ReturnsRefundsResponse
     */
    @PutMapping("/{id}")
    public ReturnsRefundsResponse update(@PathVariable Long id,
                                         @RequestBody @Valid ReturnsRefundsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a ReturnsRefunds record.
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
