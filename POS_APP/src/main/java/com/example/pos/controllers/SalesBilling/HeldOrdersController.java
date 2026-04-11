package com.example.pos.controllers.SalesBilling;

import com.example.pos.dtos.request.SalesBilling.HeldOrdersRequest;
import com.example.pos.dtos.response.SalesBilling.HeldOrdersResponse;
import com.example.pos.services.SalesBilling.HeldOrdersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: HeldOrders
 * =====================================================
 *
 * Provides standard CRUD APIs for HeldOrders.
 * All responses are returned using HeldOrdersResponse DTO.
 *
 * Endpoints:
 * - GET    /api/SalesBilling/HeldOrders
 * - GET    /api/SalesBilling/HeldOrders/{id}
 * - POST   /api/SalesBilling/HeldOrders
 * - PUT    /api/SalesBilling/HeldOrders/{id}
 * - DELETE /api/SalesBilling/HeldOrders/{id}
 */
@RestController
@RequestMapping("/api/SalesBilling/HeldOrders")
public class HeldOrdersController {

    @Autowired
    private HeldOrdersService service;

    /**
     * Retrieve all HeldOrders records.
     *
     * @return List of HeldOrdersResponse
     */
    @GetMapping
    public List<HeldOrdersResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single HeldOrders by ID.
     *
     * @param id ID of the HeldOrders
     * @return HeldOrdersResponse
     */
    @GetMapping("/{id}")
    public HeldOrdersResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new HeldOrders record.
     *
     * @param request request DTO
     * @return created HeldOrdersResponse
     */
    @PostMapping
    public HeldOrdersResponse create(@RequestBody @Valid HeldOrdersRequest request) {
        return service.create(request);
    }

    /**
     * Update existing HeldOrders record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated HeldOrdersResponse
     */
    @PutMapping("/{id}")
    public HeldOrdersResponse update(@PathVariable Long id,
                                         @RequestBody @Valid HeldOrdersRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a HeldOrders record.
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
