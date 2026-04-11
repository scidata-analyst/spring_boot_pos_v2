package com.example.pos.services.Suppliers;

import com.example.pos.dtos.request.Suppliers.SupplierDirectoryRequest;
import com.example.pos.dtos.response.Suppliers.SupplierDirectoryResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: SupplierDirectory
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all()     -> get all records
 * - index()   -> UI listing (paginated later if needed)
 * - view()    -> single record view
 * - create()  -> create new record
 * - update()  -> update existing record
 * - delete()  -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface SupplierDirectoryService {

    List<SupplierDirectoryResponse> all();

    List<SupplierDirectoryResponse> index();

    SupplierDirectoryResponse view(Long id);

    SupplierDirectoryResponse create(SupplierDirectoryRequest request);

    SupplierDirectoryResponse update(Long id, SupplierDirectoryRequest request);

    void delete(Long id);
}
