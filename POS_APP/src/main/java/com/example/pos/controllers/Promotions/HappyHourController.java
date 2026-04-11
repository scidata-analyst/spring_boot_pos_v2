package com.example.pos.controllers.Promotions;

import com.example.pos.dtos.request.Promotions.HappyHourRequest;
import com.example.pos.dtos.response.Promotions.HappyHourResponse;
import com.example.pos.services.Promotions.HappyHourService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: HappyHour
 * =====================================================
 *
 * Provides standard CRUD APIs for HappyHour.
 * All responses are returned using HappyHourResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Promotions/HappyHour
 * - GET    /api/Promotions/HappyHour/{id}
 * - POST   /api/Promotions/HappyHour
 * - PUT    /api/Promotions/HappyHour/{id}
 * - DELETE /api/Promotions/HappyHour/{id}
 */
@RestController
@RequestMapping("/api/Promotions/HappyHour")
public class HappyHourController {

    @Autowired
    private HappyHourService service;

    /**
     * Retrieve all HappyHour records.
     *
     * @return List of HappyHourResponse
     */
    @GetMapping
    public List<HappyHourResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single HappyHour by ID.
     *
     * @param id ID of the HappyHour
     * @return HappyHourResponse
     */
    @GetMapping("/{id}")
    public HappyHourResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new HappyHour record.
     *
     * @param request request DTO
     * @return created HappyHourResponse
     */
    @PostMapping
    public HappyHourResponse create(@RequestBody @Valid HappyHourRequest request) {
        return service.create(request);
    }

    /**
     * Update existing HappyHour record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated HappyHourResponse
     */
    @PutMapping("/{id}")
    public HappyHourResponse update(@PathVariable Long id,
                                         @RequestBody @Valid HappyHourRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a HappyHour record.
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
