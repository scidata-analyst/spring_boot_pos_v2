package com.example.pos.controllers.Hardware;

import com.example.pos.dtos.request.Hardware.DevicesRequest;
import com.example.pos.dtos.response.Hardware.DevicesResponse;
import com.example.pos.services.Hardware.DevicesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing Devices operations.
 * Provides standard CRUD endpoints for Devices.
 * All responses are returned using DevicesResponse DTO.
 */
@RestController
@RequestMapping(""/api/Hardware/Devices"")
public class DevicesController {

    @Autowired
    private DevicesService service;

    /**
     * Retrieve all Devices records.
     * @return List of DevicesResponse
     */
    @GetMapping
    public List<DevicesResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single Devices by its ID.
     * @param id ID of the Devices
     * @return DevicesResponse object
     */
    @GetMapping(""/{id}"")
    public DevicesResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new Devices record.
     * @param request DTO containing the Devices data
     * @return Created DevicesResponse
     */
    @PostMapping
    public DevicesResponse create(@RequestBody @Valid DevicesRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing Devices by its ID.
     * @param id ID of the Devices to update
     * @param request DTO containing updated data
     * @return Updated DevicesResponse
     */
    @PutMapping(""/{id}"")
    public DevicesResponse update(@PathVariable Long id, @RequestBody @Valid DevicesRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a Devices by its ID.
     * @param id ID of the Devices to delete
     * @return Success message
     */
    @DeleteMapping(""/{id}"")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return ""Deleted successfully"";
    }
}
