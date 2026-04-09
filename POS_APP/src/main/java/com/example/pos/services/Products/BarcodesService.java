package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.BarcodesRequest;
import com.example.pos.dtos.response.Products.BarcodesResponse;
import java.util.List;

/**
 * Service interface for Barcodes.
 * Defines standard CRUD operations for Barcodes, same as Controller methods.
 */
public interface BarcodesService {

    /**
     * Retrieve all Barcodes records.
     * @return List of BarcodesResponse
     */
    List<BarcodesResponse> getAll();

    /**
     * Retrieve a single Barcodes by its ID.
     * @param id ID of the Barcodes
     * @return BarcodesResponse object
     */
    BarcodesResponse get(Long id);

    /**
     * Create a new Barcodes record.
     * @param request DTO containing the Barcodes data
     * @return Created BarcodesResponse
     */
    BarcodesResponse create(BarcodesRequest request);

    /**
     * Update an existing Barcodes by its ID.
     * @param id ID of the Barcodes to update
     * @param request DTO containing updated data
     * @return Updated BarcodesResponse
     */
    BarcodesResponse update(Long id, BarcodesRequest request);

    /**
     * Delete a Barcodes by its ID.
     * @param id ID of the Barcodes to delete
     */
    void delete(Long id);
}
