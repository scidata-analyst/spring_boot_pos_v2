package com.example.pos.services.ReportsAnalytics;

import com.example.pos.dtos.request.ReportsAnalytics.CustomBuilderRequest;
import com.example.pos.dtos.response.ReportsAnalytics.CustomBuilderResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: CustomBuilder
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
public interface CustomBuilderService {

    List<CustomBuilderResponse> all();

    List<CustomBuilderResponse> index();

    CustomBuilderResponse view(Long id);

    CustomBuilderResponse create(CustomBuilderRequest request);

    CustomBuilderResponse update(Long id, CustomBuilderRequest request);

    void delete(Long id);
}
