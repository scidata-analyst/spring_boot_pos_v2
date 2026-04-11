package com.example.pos.controllers.POSTerminal;

import com.example.pos.dtos.request.POSTerminal.POSTerminalRequest;
import com.example.pos.dtos.response.POSTerminal.POSTerminalResponse;
import com.example.pos.services.POSTerminal.POSTerminalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: POSTerminal
 * =====================================================
 *
 * Provides standard CRUD APIs for POSTerminal.
 * All responses are returned using POSTerminalResponse DTO.
 *
 * Endpoints:
 * - GET    /api/POSTerminal/POSTerminal
 * - GET    /api/POSTerminal/POSTerminal/{id}
 * - POST   /api/POSTerminal/POSTerminal
 * - PUT    /api/POSTerminal/POSTerminal/{id}
 * - DELETE /api/POSTerminal/POSTerminal/{id}
 */
@RestController
@RequestMapping("/api/POSTerminal/POSTerminal")
public class POSTerminalController {

    @Autowired
    private POSTerminalService service;

    /**
     * Retrieve all POSTerminal records.
     *
     * @return List of POSTerminalResponse
     */
    @GetMapping
    public List<POSTerminalResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single POSTerminal by ID.
     *
     * @param id ID of the POSTerminal
     * @return POSTerminalResponse
     */
    @GetMapping("/{id}")
    public POSTerminalResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new POSTerminal record.
     *
     * @param request request DTO
     * @return created POSTerminalResponse
     */
    @PostMapping
    public POSTerminalResponse create(@RequestBody @Valid POSTerminalRequest request) {
        return service.create(request);
    }

    /**
     * Update existing POSTerminal record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated POSTerminalResponse
     */
    @PutMapping("/{id}")
    public POSTerminalResponse update(@PathVariable Long id,
                                         @RequestBody @Valid POSTerminalRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a POSTerminal record.
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
