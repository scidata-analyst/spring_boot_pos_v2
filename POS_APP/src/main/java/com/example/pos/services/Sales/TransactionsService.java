package com.example.pos.services.Sales;

import com.example.pos.dtos.request.Sales.TransactionsRequest;
import com.example.pos.dtos.response.Sales.TransactionsResponse;
import java.util.List;

/**
 * Service interface for Transactions.
 * Defines standard CRUD operations for Transactions, same as Controller methods.
 */
public interface TransactionsService {

    /**
     * Retrieve all Transactions records.
     * @return List of TransactionsResponse
     */
    List<TransactionsResponse> getAll();

    /**
     * Retrieve a single Transactions by its ID.
     * @param id ID of the Transactions
     * @return TransactionsResponse object
     */
    TransactionsResponse get(Long id);

    /**
     * Create a new Transactions record.
     * @param request DTO containing the Transactions data
     * @return Created TransactionsResponse
     */
    TransactionsResponse create(TransactionsRequest request);

    /**
     * Update an existing Transactions by its ID.
     * @param id ID of the Transactions to update
     * @param request DTO containing updated data
     * @return Updated TransactionsResponse
     */
    TransactionsResponse update(Long id, TransactionsRequest request);

    /**
     * Delete a Transactions by its ID.
     * @param id ID of the Transactions to delete
     */
    void delete(Long id);
}
