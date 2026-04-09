package com.example.pos.services.Suppliers;

import com.example.pos.dtos.request.Suppliers.SupplierPaymentsRequest;
import com.example.pos.dtos.response.Suppliers.SupplierPaymentsResponse;
import java.util.List;

/**
 * Service interface for SupplierPayments.
 * Defines standard CRUD operations for SupplierPayments, same as Controller methods.
 */
public interface SupplierPaymentsService {

    /**
     * Retrieve all SupplierPayments records.
     * @return List of SupplierPaymentsResponse
     */
    List<SupplierPaymentsResponse> getAll();

    /**
     * Retrieve a single SupplierPayments by its ID.
     * @param id ID of the SupplierPayments
     * @return SupplierPaymentsResponse object
     */
    SupplierPaymentsResponse get(Long id);

    /**
     * Create a new SupplierPayments record.
     * @param request DTO containing the SupplierPayments data
     * @return Created SupplierPaymentsResponse
     */
    SupplierPaymentsResponse create(SupplierPaymentsRequest request);

    /**
     * Update an existing SupplierPayments by its ID.
     * @param id ID of the SupplierPayments to update
     * @param request DTO containing updated data
     * @return Updated SupplierPaymentsResponse
     */
    SupplierPaymentsResponse update(Long id, SupplierPaymentsRequest request);

    /**
     * Delete a SupplierPayments by its ID.
     * @param id ID of the SupplierPayments to delete
     */
    void delete(Long id);
}
