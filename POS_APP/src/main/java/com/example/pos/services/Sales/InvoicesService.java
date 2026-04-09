package com.example.pos.services.Sales;

import com.example.pos.dtos.request.Sales.InvoicesRequest;
import com.example.pos.dtos.response.Sales.InvoicesResponse;
import java.util.List;

/**
 * Service interface for Invoices.
 * Defines standard CRUD operations for Invoices, same as Controller methods.
 */
public interface InvoicesService {

    /**
     * Retrieve all Invoices records.
     * @return List of InvoicesResponse
     */
    List<InvoicesResponse> getAll();

    /**
     * Retrieve a single Invoices by its ID.
     * @param id ID of the Invoices
     * @return InvoicesResponse object
     */
    InvoicesResponse get(Long id);

    /**
     * Create a new Invoices record.
     * @param request DTO containing the Invoices data
     * @return Created InvoicesResponse
     */
    InvoicesResponse create(InvoicesRequest request);

    /**
     * Update an existing Invoices by its ID.
     * @param id ID of the Invoices to update
     * @param request DTO containing updated data
     * @return Updated InvoicesResponse
     */
    InvoicesResponse update(Long id, InvoicesRequest request);

    /**
     * Delete a Invoices by its ID.
     * @param id ID of the Invoices to delete
     */
    void delete(Long id);
}
