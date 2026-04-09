package com.example.pos.services.Loyalty;

import com.example.pos.dtos.request.Loyalty.PointsConfigRequest;
import com.example.pos.dtos.response.Loyalty.PointsConfigResponse;
import java.util.List;

/**
 * Service interface for PointsConfig.
 * Defines standard CRUD operations for PointsConfig, same as Controller methods.
 */
public interface PointsConfigService {

    /**
     * Retrieve all PointsConfig records.
     * @return List of PointsConfigResponse
     */
    List<PointsConfigResponse> getAll();

    /**
     * Retrieve a single PointsConfig by its ID.
     * @param id ID of the PointsConfig
     * @return PointsConfigResponse object
     */
    PointsConfigResponse get(Long id);

    /**
     * Create a new PointsConfig record.
     * @param request DTO containing the PointsConfig data
     * @return Created PointsConfigResponse
     */
    PointsConfigResponse create(PointsConfigRequest request);

    /**
     * Update an existing PointsConfig by its ID.
     * @param id ID of the PointsConfig to update
     * @param request DTO containing updated data
     * @return Updated PointsConfigResponse
     */
    PointsConfigResponse update(Long id, PointsConfigRequest request);

    /**
     * Delete a PointsConfig by its ID.
     * @param id ID of the PointsConfig to delete
     */
    void delete(Long id);
}
