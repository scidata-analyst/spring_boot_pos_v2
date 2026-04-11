package com.example.pos.services.PaymentAccounting;

import com.example.pos.dtos.request.PaymentAccounting.APARRequest;
import com.example.pos.dtos.response.PaymentAccounting.APARResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: APAR
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
public interface APARService {

    List<APARResponse> all();

    List<APARResponse> index();

    APARResponse view(Long id);

    APARResponse create(APARRequest request);

    APARResponse update(Long id, APARRequest request);

    void delete(Long id);
}
