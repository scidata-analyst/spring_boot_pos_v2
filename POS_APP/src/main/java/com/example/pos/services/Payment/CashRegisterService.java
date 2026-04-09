package com.example.pos.services.Payment;

import com.example.pos.dtos.request.Payment.CashRegisterRequest;
import com.example.pos.dtos.response.Payment.CashRegisterResponse;
import java.util.List;

/**
 * Service interface for CashRegister.
 * Defines standard CRUD operations for CashRegister, same as Controller methods.
 */
public interface CashRegisterService {

    /**
     * Retrieve all CashRegister records.
     * @return List of CashRegisterResponse
     */
    List<CashRegisterResponse> getAll();

    /**
     * Retrieve a single CashRegister by its ID.
     * @param id ID of the CashRegister
     * @return CashRegisterResponse object
     */
    CashRegisterResponse get(Long id);

    /**
     * Create a new CashRegister record.
     * @param request DTO containing the CashRegister data
     * @return Created CashRegisterResponse
     */
    CashRegisterResponse create(CashRegisterRequest request);

    /**
     * Update an existing CashRegister by its ID.
     * @param id ID of the CashRegister to update
     * @param request DTO containing updated data
     * @return Updated CashRegisterResponse
     */
    CashRegisterResponse update(Long id, CashRegisterRequest request);

    /**
     * Delete a CashRegister by its ID.
     * @param id ID of the CashRegister to delete
     */
    void delete(Long id);
}
