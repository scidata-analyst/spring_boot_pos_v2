package com.example.pos.services.Sales;

import com.example.pos.dtos.request.Sales.HeldOrdersRequest;
import com.example.pos.dtos.response.Sales.HeldOrdersResponse;
import java.util.List;

/**
 * Service interface for HeldOrders.
 * Defines standard CRUD operations for HeldOrders, same as Controller methods.
 */
public interface HeldOrdersService {

    /**
     * Retrieve all HeldOrders records.
     * @return List of HeldOrdersResponse
     */
    List<HeldOrdersResponse> getAll();

    /**
     * Retrieve a single HeldOrders by its ID.
     * @param id ID of the HeldOrders
     * @return HeldOrdersResponse object
     */
    HeldOrdersResponse get(Long id);

    /**
     * Create a new HeldOrders record.
     * @param request DTO containing the HeldOrders data
     * @return Created HeldOrdersResponse
     */
    HeldOrdersResponse create(HeldOrdersRequest request);

    /**
     * Update an existing HeldOrders by its ID.
     * @param id ID of the HeldOrders to update
     * @param request DTO containing updated data
     * @return Updated HeldOrdersResponse
     */
    HeldOrdersResponse update(Long id, HeldOrdersRequest request);

    /**
     * Delete a HeldOrders by its ID.
     * @param id ID of the HeldOrders to delete
     */
    void delete(Long id);
}
