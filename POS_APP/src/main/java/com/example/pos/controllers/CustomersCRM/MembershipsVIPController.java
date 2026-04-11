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
 * Provides standard CRUD APIs for MembershipsVIP.
 * All responses are returned using MembershipsVIPResponse DTO.
 *
 * Endpoints:
 * - GET    /api/CustomersCRM/MembershipsVIP
 * - GET    /api/CustomersCRM/MembershipsVIP/{id}
 * - POST   /api/CustomersCRM/MembershipsVIP
 * - PUT    /api/CustomersCRM/MembershipsVIP/{id}
 * - DELETE /api/CustomersCRM/MembershipsVIP/{id}
 */
@RestController
@RequestMapping("/api/CustomersCRM/MembershipsVIP")
public class MembershipsVIPController {

    @Autowired
    private MembershipsVIPService service;

    /**
     * Retrieve all MembershipsVIP records.
     *
     * @return List of MembershipsVIPResponse
     */
    @GetMapping
    public List<MembershipsVIPResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single MembershipsVIP by ID.
     *
     * @param id ID of the MembershipsVIP
     * @return MembershipsVIPResponse
     */
    @GetMapping("/{id}")
    public MembershipsVIPResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new MembershipsVIP record.
     *
     * @param request request DTO
     * @return created MembershipsVIPResponse
     */
    @PostMapping
    public MembershipsVIPResponse create(@RequestBody @Valid MembershipsVIPRequest request) {
        return service.create(request);
    }

    /**
     * Update existing MembershipsVIP record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated MembershipsVIPResponse
     */
    @PutMapping("/{id}")
    public MembershipsVIPResponse update(@PathVariable Long id,
                                         @RequestBody @Valid MembershipsVIPRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a MembershipsVIP record.
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
