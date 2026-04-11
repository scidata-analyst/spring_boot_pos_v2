package com.example.pos.services.UsersRoles;

import com.example.pos.dtos.request.UsersRoles.CashierAccountsRequest;
import com.example.pos.dtos.response.UsersRoles.CashierAccountsResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: CashierAccounts
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
public interface CashierAccountsService {

    List<CashierAccountsResponse> all();

    List<CashierAccountsResponse> index();

    CashierAccountsResponse view(Long id);

    CashierAccountsResponse create(CashierAccountsRequest request);

    CashierAccountsResponse update(Long id, CashierAccountsRequest request);

    void delete(Long id);
}
