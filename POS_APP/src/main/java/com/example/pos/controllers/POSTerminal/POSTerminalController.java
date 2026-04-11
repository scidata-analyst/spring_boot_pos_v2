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
 * Provides standard REST APIs for POSTerminal.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/POSTerminal/POSTerminal")
public class POSTerminalController {

    @Autowired
    private POSTerminalService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<POSTerminalResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<POSTerminalResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public POSTerminalResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public POSTerminalResponse create(@RequestBody @Valid POSTerminalRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public POSTerminalResponse update(@PathVariable Long id,
            @RequestBody @Valid POSTerminalRequest request) {
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
