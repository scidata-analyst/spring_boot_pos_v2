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
 * Provides standard CRUD APIs for DevicesPrinters.
 * All responses are returned using DevicesPrintersResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Hardware/DevicesPrinters
 * - GET    /api/Hardware/DevicesPrinters/{id}
 * - POST   /api/Hardware/DevicesPrinters
 * - PUT    /api/Hardware/DevicesPrinters/{id}
 * - DELETE /api/Hardware/DevicesPrinters/{id}
 */
@RestController
@RequestMapping("/api/Hardware/DevicesPrinters")
public class DevicesPrintersController {

    @Autowired
    private DevicesPrintersService service;

    /**
     * Retrieve all DevicesPrinters records.
     *
     * @return List of DevicesPrintersResponse
     */
    @GetMapping
    public List<DevicesPrintersResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single DevicesPrinters by ID.
     *
     * @param id ID of the DevicesPrinters
     * @return DevicesPrintersResponse
     */
    @GetMapping("/{id}")
    public DevicesPrintersResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new DevicesPrinters record.
     *
     * @param request request DTO
     * @return created DevicesPrintersResponse
     */
    @PostMapping
    public DevicesPrintersResponse create(@RequestBody @Valid DevicesPrintersRequest request) {
        return service.create(request);
    }

    /**
     * Update existing DevicesPrinters record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated DevicesPrintersResponse
     */
    @PutMapping("/{id}")
    public DevicesPrintersResponse update(@PathVariable Long id,
                                         @RequestBody @Valid DevicesPrintersRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a DevicesPrinters record.
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
