package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.BarcodeSKURequest;
import com.example.pos.dtos.response.Products.BarcodeSKUResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: BarcodeSKU
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
public interface BarcodeSKUService {

    List<BarcodeSKUResponse> all();

    List<BarcodeSKUResponse> index();

    BarcodeSKUResponse view(Long id);

    BarcodeSKUResponse create(BarcodeSKURequest request);

    BarcodeSKUResponse update(Long id, BarcodeSKURequest request);

    void delete(Long id);
}
