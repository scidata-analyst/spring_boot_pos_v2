package com.example.pos.services.Suppliers;

import com.example.pos.dtos.request.Suppliers.PurchaseOrdersRequest;
import com.example.pos.dtos.response.Suppliers.PurchaseOrdersResponse;
import java.util.List;

/**
 * Service interface for PurchaseOrders.
 * Defines standard CRUD operations for PurchaseOrders, same as Controller methods.
 */
public interface PurchaseOrdersService {

    /**
     * Retrieve all PurchaseOrders records.
     * @return List of PurchaseOrdersResponse
     */
    List<PurchaseOrdersResponse> getAll();

    /**
     * Retrieve a single PurchaseOrders by its ID.
     * @param id ID of the PurchaseOrders
     * @return PurchaseOrdersResponse object
     */
    PurchaseOrdersResponse get(Long id);

    /**
     * Create a new PurchaseOrders record.
     * @param request DTO containing the PurchaseOrders data
     * @return Created PurchaseOrdersResponse
     */
    PurchaseOrdersResponse create(PurchaseOrdersRequest request);

    /**
     * Update an existing PurchaseOrders by its ID.
     * @param id ID of the PurchaseOrders to update
     * @param request DTO containing updated data
     * @return Updated PurchaseOrdersResponse
     */
    PurchaseOrdersResponse update(Long id, PurchaseOrdersRequest request);

    /**
     * Delete a PurchaseOrders by its ID.
     * @param id ID of the PurchaseOrders to delete
     */
    void delete(Long id);
}
