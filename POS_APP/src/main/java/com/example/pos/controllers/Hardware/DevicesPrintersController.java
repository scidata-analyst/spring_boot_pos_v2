package com.example.pos.controllers.Hardware;

import com.example.pos.dtos.request.Hardware.DevicesPrintersRequest;
import com.example.pos.dtos.response.Hardware.DevicesPrintersResponse;
import com.example.pos.services.Hardware.DevicesPrintersService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: DevicesPrinters
 * =====================================================
 *
 * Provides standard REST APIs for DevicesPrinters.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Hardware/DevicesPrinters")
public class DevicesPrintersController {

    @Autowired
    private DevicesPrintersService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<DevicesPrintersResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<DevicesPrintersResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public DevicesPrintersResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public DevicesPrintersResponse create(@RequestBody @Valid DevicesPrintersRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public DevicesPrintersResponse update(@PathVariable Long id,
            @RequestBody @Valid DevicesPrintersRequest request) {
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
