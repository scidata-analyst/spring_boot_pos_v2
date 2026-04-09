package com.example.pos.services.Hardware;

import com.example.pos.dtos.request.Hardware.DevicesRequest;
import com.example.pos.dtos.response.Hardware.DevicesResponse;
import java.util.List;

/**
 * Service interface for Devices.
 * Defines standard CRUD operations for Devices, same as Controller methods.
 */
public interface DevicesService {

    /**
     * Retrieve all Devices records.
     * @return List of DevicesResponse
     */
    List<DevicesResponse> getAll();

    /**
     * Retrieve a single Devices by its ID.
     * @param id ID of the Devices
     * @return DevicesResponse object
     */
    DevicesResponse get(Long id);

    /**
     * Create a new Devices record.
     * @param request DTO containing the Devices data
     * @return Created DevicesResponse
     */
    DevicesResponse create(DevicesRequest request);

    /**
     * Update an existing Devices by its ID.
     * @param id ID of the Devices to update
     * @param request DTO containing updated data
     * @return Updated DevicesResponse
     */
    DevicesResponse update(Long id, DevicesRequest request);

    /**
     * Delete a Devices by its ID.
     * @param id ID of the Devices to delete
     */
    void delete(Long id);
}
