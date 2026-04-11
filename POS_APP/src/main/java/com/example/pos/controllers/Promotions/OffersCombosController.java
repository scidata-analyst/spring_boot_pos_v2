package com.example.pos.controllers.Promotions;

import com.example.pos.dtos.request.Promotions.OffersCombosRequest;
import com.example.pos.dtos.response.Promotions.OffersCombosResponse;
import com.example.pos.services.Promotions.OffersCombosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: OffersCombos
 * =====================================================
 *
 * Provides standard CRUD APIs for OffersCombos.
 * All responses are returned using OffersCombosResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Promotions/OffersCombos
 * - GET    /api/Promotions/OffersCombos/{id}
 * - POST   /api/Promotions/OffersCombos
 * - PUT    /api/Promotions/OffersCombos/{id}
 * - DELETE /api/Promotions/OffersCombos/{id}
 */
@RestController
@RequestMapping("/api/Promotions/OffersCombos")
public class OffersCombosController {

    @Autowired
    private OffersCombosService service;

    /**
     * Retrieve all OffersCombos records.
     *
     * @return List of OffersCombosResponse
     */
    @GetMapping
    public List<OffersCombosResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single OffersCombos by ID.
     *
     * @param id ID of the OffersCombos
     * @return OffersCombosResponse
     */
    @GetMapping("/{id}")
    public OffersCombosResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new OffersCombos record.
     *
     * @param request request DTO
     * @return created OffersCombosResponse
     */
    @PostMapping
    public OffersCombosResponse create(@RequestBody @Valid OffersCombosRequest request) {
        return service.create(request);
    }

    /**
     * Update existing OffersCombos record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated OffersCombosResponse
     */
    @PutMapping("/{id}")
    public OffersCombosResponse update(@PathVariable Long id,
                                         @RequestBody @Valid OffersCombosRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a OffersCombos record.
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
