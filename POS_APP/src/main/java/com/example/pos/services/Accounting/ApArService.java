package com.example.pos.services.Accounting;

import com.example.pos.dtos.request.Accounting.ApArRequest;
import com.example.pos.dtos.response.Accounting.ApArResponse;
import java.util.List;

/**
 * Service interface for ApAr.
 * Defines standard CRUD operations for ApAr, same as Controller methods.
 */
public interface ApArService {

    /**
     * Retrieve all ApAr records.
     * @return List of ApArResponse
     */
    List<ApArResponse> getAll();

    /**
     * Retrieve a single ApAr by its ID.
     * @param id ID of the ApAr
     * @return ApArResponse object
     */
    ApArResponse get(Long id);

    /**
     * Create a new ApAr record.
     * @param request DTO containing the ApAr data
     * @return Created ApArResponse
     */
    ApArResponse create(ApArRequest request);

    /**
     * Update an existing ApAr by its ID.
     * @param id ID of the ApAr to update
     * @param request DTO containing updated data
     * @return Updated ApArResponse
     */
    ApArResponse update(Long id, ApArRequest request);

    /**
     * Delete a ApAr by its ID.
     * @param id ID of the ApAr to delete
     */
    void delete(Long id);
}
