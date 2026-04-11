package com.example.pos.services.Promotions;

import com.example.pos.dtos.request.Promotions.OffersCombosRequest;
import com.example.pos.dtos.response.Promotions.OffersCombosResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: OffersCombos
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
public interface OffersCombosService {

    List<OffersCombosResponse> all();

    List<OffersCombosResponse> index();

    OffersCombosResponse view(Long id);

    OffersCombosResponse create(OffersCombosRequest request);

    OffersCombosResponse update(Long id, OffersCombosRequest request);

    void delete(Long id);
}
