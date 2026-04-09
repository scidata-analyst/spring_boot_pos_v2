package com.example.pos.services.Core;

import com.example.pos.dtos.request.Core.PosTerminalRequest;
import com.example.pos.dtos.response.Core.PosTerminalResponse;
import java.util.List;

/**
 * Service interface for PosTerminal.
 * Defines standard CRUD operations for PosTerminal, same as Controller methods.
 */
public interface PosTerminalService {

    /**
     * Retrieve all PosTerminal records.
     * @return List of PosTerminalResponse
     */
    List<PosTerminalResponse> getAll();

    /**
     * Retrieve a single PosTerminal by its ID.
     * @param id ID of the PosTerminal
     * @return PosTerminalResponse object
     */
    PosTerminalResponse get(Long id);

    /**
     * Create a new PosTerminal record.
     * @param request DTO containing the PosTerminal data
     * @return Created PosTerminalResponse
     */
    PosTerminalResponse create(PosTerminalRequest request);

    /**
     * Update an existing PosTerminal by its ID.
     * @param id ID of the PosTerminal to update
     * @param request DTO containing updated data
     * @return Updated PosTerminalResponse
     */
    PosTerminalResponse update(Long id, PosTerminalRequest request);

    /**
     * Delete a PosTerminal by its ID.
     * @param id ID of the PosTerminal to delete
     */
    void delete(Long id);
}
