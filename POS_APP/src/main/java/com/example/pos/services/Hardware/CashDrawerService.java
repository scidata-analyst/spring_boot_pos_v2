package com.example.pos.services.Hardware;

import com.example.pos.dtos.request.Hardware.CashDrawerRequest;
import com.example.pos.dtos.response.Hardware.CashDrawerResponse;
import java.util.List;

/**
 * Service interface for CashDrawer.
 * Defines standard CRUD operations for CashDrawer, same as Controller methods.
 */
public interface CashDrawerService {

    /**
     * Retrieve all CashDrawer records.
     * @return List of CashDrawerResponse
     */
    List<CashDrawerResponse> getAll();

    /**
     * Retrieve a single CashDrawer by its ID.
     * @param id ID of the CashDrawer
     * @return CashDrawerResponse object
     */
    CashDrawerResponse get(Long id);

    /**
     * Create a new CashDrawer record.
     * @param request DTO containing the CashDrawer data
     * @return Created CashDrawerResponse
     */
    CashDrawerResponse create(CashDrawerRequest request);

    /**
     * Update an existing CashDrawer by its ID.
     * @param id ID of the CashDrawer to update
     * @param request DTO containing updated data
     * @return Updated CashDrawerResponse
     */
    CashDrawerResponse update(Long id, CashDrawerRequest request);

    /**
     * Delete a CashDrawer by its ID.
     * @param id ID of the CashDrawer to delete
     */
    void delete(Long id);
}
