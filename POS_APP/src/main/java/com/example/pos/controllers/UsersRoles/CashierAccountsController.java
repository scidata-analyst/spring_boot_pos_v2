package com.example.pos.controllers.UsersRoles;

import com.example.pos.dtos.request.UsersRoles.CashierAccountsRequest;
import com.example.pos.dtos.response.UsersRoles.CashierAccountsResponse;
import com.example.pos.services.UsersRoles.CashierAccountsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: CashierAccounts
 * =====================================================
 *
 * Provides standard CRUD APIs for CashierAccounts.
 * All responses are returned using CashierAccountsResponse DTO.
 *
 * Endpoints:
 * - GET    /api/UsersRoles/CashierAccounts
 * - GET    /api/UsersRoles/CashierAccounts/{id}
 * - POST   /api/UsersRoles/CashierAccounts
 * - PUT    /api/UsersRoles/CashierAccounts/{id}
 * - DELETE /api/UsersRoles/CashierAccounts/{id}
 */
@RestController
@RequestMapping("/api/UsersRoles/CashierAccounts")
public class CashierAccountsController {

    @Autowired
    private CashierAccountsService service;

    /**
     * Retrieve all CashierAccounts records.
     *
     * @return List of CashierAccountsResponse
     */
    @GetMapping
    public List<CashierAccountsResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single CashierAccounts by ID.
     *
     * @param id ID of the CashierAccounts
     * @return CashierAccountsResponse
     */
    @GetMapping("/{id}")
    public CashierAccountsResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new CashierAccounts record.
     *
     * @param request request DTO
     * @return created CashierAccountsResponse
     */
    @PostMapping
    public CashierAccountsResponse create(@RequestBody @Valid CashierAccountsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing CashierAccounts record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated CashierAccountsResponse
     */
    @PutMapping("/{id}")
    public CashierAccountsResponse update(@PathVariable Long id,
                                         @RequestBody @Valid CashierAccountsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a CashierAccounts record.
     *
     * @param id record ID
     * @return success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
