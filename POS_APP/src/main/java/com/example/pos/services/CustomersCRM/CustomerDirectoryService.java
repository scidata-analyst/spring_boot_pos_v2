package com.example.pos.services.CustomersCRM;

import com.example.pos.dtos.request.CustomersCRM.CustomerDirectoryRequest;
import com.example.pos.dtos.response.CustomersCRM.CustomerDirectoryResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: CustomerDirectory
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
public interface CustomerDirectoryService {

    List<CustomerDirectoryResponse> all();

    List<CustomerDirectoryResponse> index();

    CustomerDirectoryResponse view(Long id);

    CustomerDirectoryResponse create(CustomerDirectoryRequest request);

    CustomerDirectoryResponse update(Long id, CustomerDirectoryRequest request);

    void delete(Long id);
}
