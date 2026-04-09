package com.example.pos.services.Promos;

import com.example.pos.dtos.request.Promos.HappyHourRequest;
import com.example.pos.dtos.response.Promos.HappyHourResponse;
import java.util.List;

/**
 * Service interface for HappyHour.
 * Defines standard CRUD operations for HappyHour, same as Controller methods.
 */
public interface HappyHourService {

    /**
     * Retrieve all HappyHour records.
     * @return List of HappyHourResponse
     */
    List<HappyHourResponse> getAll();

    /**
     * Retrieve a single HappyHour by its ID.
     * @param id ID of the HappyHour
     * @return HappyHourResponse object
     */
    HappyHourResponse get(Long id);

    /**
     * Create a new HappyHour record.
     * @param request DTO containing the HappyHour data
     * @return Created HappyHourResponse
     */
    HappyHourResponse create(HappyHourRequest request);

    /**
     * Update an existing HappyHour by its ID.
     * @param id ID of the HappyHour to update
     * @param request DTO containing updated data
     * @return Updated HappyHourResponse
     */
    HappyHourResponse update(Long id, HappyHourRequest request);

    /**
     * Delete a HappyHour by its ID.
     * @param id ID of the HappyHour to delete
     */
    void delete(Long id);
}
