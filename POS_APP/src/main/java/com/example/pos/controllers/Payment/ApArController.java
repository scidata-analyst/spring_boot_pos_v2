package com.example.pos.controllers.Payment;

import com.example.pos.dtos.request.Payment.ApArRequest;
import com.example.pos.dtos.response.Payment.ApArResponse;
import com.example.pos.services.Payment.ApArService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing ApAr operations.
 * Provides standard CRUD endpoints for ApAr.
 * All responses are returned using ApArResponse DTO.
 */
@RestController
@RequestMapping("/api/Payment/ApAr")
public class ApArController {

    @Autowired
    private ApArService service;

    /**
     * Retrieve all ApAr records.
     * 
     * @return List of ApArResponse
     */
    @GetMapping
    public List<ApArResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single ApAr by its ID.
     * 
     * @param id ID of the ApAr
     * @return ApArResponse object
     */
    @GetMapping("/{id}")
    public ApArResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new ApAr record.
     * 
     * @param request DTO containing the ApAr data
     * @return Created ApArResponse
     */
    @PostMapping
    public ApArResponse create(@RequestBody @Valid ApArRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing ApAr by its ID.
     * 
     * @param id      ID of the ApAr to update
     * @param request DTO containing updated data
     * @return Updated ApArResponse
     */
    @PutMapping("/{id}")
    public ApArResponse update(@PathVariable Long id, @RequestBody @Valid ApArRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a ApAr by its ID.
     * 
     * @param id ID of the ApAr to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
