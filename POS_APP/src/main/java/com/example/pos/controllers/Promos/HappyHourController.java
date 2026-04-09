package com.example.pos.controllers.Promos;

import com.example.pos.dtos.request.Promos.HappyHourRequest;
import com.example.pos.dtos.response.Promos.HappyHourResponse;
import com.example.pos.services.Promos.HappyHourService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing HappyHour operations.
 * Provides standard CRUD endpoints for HappyHour.
 * All responses are returned using HappyHourResponse DTO.
 */
@RestController
@RequestMapping(""/api/Promos/HappyHour"")
public class HappyHourController {

    @Autowired
    private HappyHourService service;

    /**
     * Retrieve all HappyHour records.
     * @return List of HappyHourResponse
     */
    @GetMapping
    public List<HappyHourResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single HappyHour by its ID.
     * @param id ID of the HappyHour
     * @return HappyHourResponse object
     */
    @GetMapping(""/{id}"")
    public HappyHourResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new HappyHour record.
     * @param request DTO containing the HappyHour data
     * @return Created HappyHourResponse
     */
    @PostMapping
    public HappyHourResponse create(@RequestBody @Valid HappyHourRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing HappyHour by its ID.
     * @param id ID of the HappyHour to update
     * @param request DTO containing updated data
     * @return Updated HappyHourResponse
     */
    @PutMapping(""/{id}"")
    public HappyHourResponse update(@PathVariable Long id, @RequestBody @Valid HappyHourRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a HappyHour by its ID.
     * @param id ID of the HappyHour to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
