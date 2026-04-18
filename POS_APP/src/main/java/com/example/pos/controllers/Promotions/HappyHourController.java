package com.example.pos.controllers.Promotions;

import com.example.pos.dtos.request.Promotions.HappyHourRequest;
import com.example.pos.dtos.response.Promotions.HappyHourResponse;
import com.example.pos.services.Promotions.HappyHourService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * =====================================================
 * REST Controller: HappyHour
 * =====================================================
 *
 * Provides standard REST APIs for HappyHour.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Promotions/HappyHour")
public class HappyHourController {

    @Autowired
    private HappyHourService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<HappyHourResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public Page<HappyHourResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public HappyHourResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public HappyHourResponse create(@RequestBody @Valid HappyHourRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public HappyHourResponse update(@PathVariable Long id,
            @RequestBody @Valid HappyHourRequest request) {
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
