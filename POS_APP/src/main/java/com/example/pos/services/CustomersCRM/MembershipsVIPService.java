package com.example.pos.services.CustomersCRM;

import com.example.pos.dtos.request.CustomersCRM.MembershipsVIPRequest;
import com.example.pos.dtos.response.CustomersCRM.MembershipsVIPResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: MembershipsVIP
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
public interface MembershipsVIPService {

    List<MembershipsVIPResponse> all();

    List<MembershipsVIPResponse> index();

    MembershipsVIPResponse view(Long id);

    MembershipsVIPResponse create(MembershipsVIPRequest request);

    MembershipsVIPResponse update(Long id, MembershipsVIPRequest request);

    void delete(Long id);
}
