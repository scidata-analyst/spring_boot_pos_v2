package com.example.pos.services.Promotions;

import com.example.pos.dtos.request.Promotions.HappyHourRequest;
import com.example.pos.dtos.response.Promotions.HappyHourResponse;

import java.util.List;

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

    List<HappyHourResponse> index();

    HappyHourResponse view(Long id);

    HappyHourResponse create(HappyHourRequest request);

    HappyHourResponse update(Long id, HappyHourRequest request);

    void delete(Long id);
}
