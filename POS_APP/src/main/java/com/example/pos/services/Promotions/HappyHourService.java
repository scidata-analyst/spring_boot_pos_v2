package com.example.pos.services.Promotions;

import com.example.pos.dtos.request.Promotions.HappyHourRequest;
import com.example.pos.dtos.response.Promotions.HappyHourResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * =====================================================
 * Service Contract: HappyHour
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
public interface HappyHourService {

    List<HappyHourResponse> all();

    Page<HappyHourResponse> index(String search, Pageable pageable);

    HappyHourResponse view(Long id);

    HappyHourResponse create(HappyHourRequest request);

    HappyHourResponse update(Long id, HappyHourRequest request);

    void delete(Long id);
}
