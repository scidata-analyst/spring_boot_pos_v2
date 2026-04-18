package com.example.pos.services.Promotions;

import com.example.pos.dtos.request.Promotions.OffersCombosRequest;
import com.example.pos.dtos.response.Promotions.OffersCombosResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: OffersCombos
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
public interface OffersCombosService {

    List<OffersCombosResponse> all();

    Page<OffersCombosResponse> index(String search, Pageable pageable);

    OffersCombosResponse view(Long id);

    OffersCombosResponse create(OffersCombosRequest request);

    OffersCombosResponse update(Long id, OffersCombosRequest request);

    void delete(Long id);
}
