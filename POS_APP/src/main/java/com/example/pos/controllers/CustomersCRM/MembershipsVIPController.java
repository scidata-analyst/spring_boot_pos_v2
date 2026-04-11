package com.example.pos.controllers.CustomersCRM;

import com.example.pos.dtos.request.CustomersCRM.MembershipsVIPRequest;
import com.example.pos.dtos.response.CustomersCRM.MembershipsVIPResponse;
import com.example.pos.services.CustomersCRM.MembershipsVIPService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: MembershipsVIP
 * =====================================================
 *
 * Provides standard REST APIs for MembershipsVIP.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/CustomersCRM/MembershipsVIP")
public class MembershipsVIPController {

    @Autowired
    private MembershipsVIPService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<MembershipsVIPResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<MembershipsVIPResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public MembershipsVIPResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public MembershipsVIPResponse create(@RequestBody @Valid MembershipsVIPRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public MembershipsVIPResponse update(@PathVariable Long id,
            @RequestBody @Valid MembershipsVIPRequest request) {
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
