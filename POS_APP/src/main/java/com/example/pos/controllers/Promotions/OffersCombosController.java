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
 * Provides standard REST APIs for OffersCombos.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Promotions/OffersCombos")
public class OffersCombosController {

    @Autowired
    private OffersCombosService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<OffersCombosResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<OffersCombosResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public OffersCombosResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public OffersCombosResponse create(@RequestBody @Valid OffersCombosRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public OffersCombosResponse update(@PathVariable Long id,
            @RequestBody @Valid OffersCombosRequest request) {
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
