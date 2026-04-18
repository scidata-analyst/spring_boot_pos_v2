package com.example.pos.controllers.UsersRoles;

import com.example.pos.dtos.request.UsersRoles.CashierAccountsRequest;
import com.example.pos.dtos.response.UsersRoles.CashierAccountsResponse;
import com.example.pos.services.UsersRoles.CashierAccountsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * =====================================================
 * REST Controller: CashierAccounts
 * =====================================================
 *
 * Provides standard REST APIs for CashierAccounts.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/UsersRoles/CashierAccounts")
public class CashierAccountsController {

    @Autowired
    private CashierAccountsService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public java.util.List<CashierAccountsResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     * Query params: page, size, sort, search
     */
    @GetMapping("/index")
    public Page<CashierAccountsResponse> index(@RequestParam(required = false) String search, Pageable pageable) {
        return service.index(search, pageable);
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public CashierAccountsResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public CashierAccountsResponse create(@RequestBody @Valid CashierAccountsRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public CashierAccountsResponse update(@PathVariable Long id,
            @RequestBody @Valid CashierAccountsRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete record.
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
