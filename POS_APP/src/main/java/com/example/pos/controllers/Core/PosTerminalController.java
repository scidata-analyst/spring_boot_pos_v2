package com.example.pos.controllers.Core;

import com.example.pos.dtos.request.Core.PosTerminalRequest;
import com.example.pos.dtos.response.Core.PosTerminalResponse;
import com.example.pos.services.Core.PosTerminalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing PosTerminal operations.
 * Provides standard CRUD endpoints for PosTerminal.
 * All responses are returned using PosTerminalResponse DTO.
 */
@RestController
@RequestMapping("/api/Core/PosTerminal")
public class PosTerminalController {

    @Autowired
    private PosTerminalService service;

    /**
     * Retrieve all PosTerminal records.
     * 
     * @return List of PosTerminalResponse
     */
    @GetMapping
    public List<PosTerminalResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single PosTerminal by its ID.
     * 
     * @param id ID of the PosTerminal
     * @return PosTerminalResponse object
     */
    @GetMapping("/{id}")
    public PosTerminalResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new PosTerminal record.
     * 
     * @param request DTO containing the PosTerminal data
     * @return Created PosTerminalResponse
     */
    @PostMapping
    public PosTerminalResponse create(@RequestBody @Valid PosTerminalRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing PosTerminal by its ID.
     * 
     * @param id      ID of the PosTerminal to update
     * @param request DTO containing updated data
     * @return Updated PosTerminalResponse
     */
    @PutMapping("/{id}")
    public PosTerminalResponse update(@PathVariable Long id, @RequestBody @Valid PosTerminalRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a PosTerminal by its ID.
     * 
     * @param id ID of the PosTerminal to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
