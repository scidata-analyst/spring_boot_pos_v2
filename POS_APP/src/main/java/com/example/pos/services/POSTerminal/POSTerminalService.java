package com.example.pos.services.POSTerminal;

import com.example.pos.dtos.request.POSTerminal.POSTerminalRequest;
import com.example.pos.dtos.response.POSTerminal.POSTerminalResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: POSTerminal
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all() -> get all records
 * - index() -> UI listing (paginated later if needed)
 * - view() -> single record view
 * - create() -> create new record
 * - update() -> update existing record
 * - delete() -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface POSTerminalService {

    List<POSTerminalResponse> all();

    Page<POSTerminalResponse> index(String search, Pageable pageable);

    POSTerminalResponse view(Long id);

    POSTerminalResponse create(POSTerminalRequest request);

    POSTerminalResponse update(Long id, POSTerminalRequest request);

    void delete(Long id);
}
