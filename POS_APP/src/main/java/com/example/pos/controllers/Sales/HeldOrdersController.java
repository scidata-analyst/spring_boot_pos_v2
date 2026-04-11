package com.example.pos.controllers.Sales;

import com.example.pos.dtos.request.Sales.HeldOrdersRequest;
import com.example.pos.dtos.response.Sales.HeldOrdersResponse;
import com.example.pos.services.Sales.HeldOrdersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing HeldOrders operations.
 * Provides standard CRUD endpoints for HeldOrders.
 * All responses are returned using HeldOrdersResponse DTO.
 */
@RestController
@RequestMapping("/api/Sales/HeldOrders")
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
     * Retrieve a single HeldOrders by its ID.
     * 
     * @param id ID of the HeldOrders
     * @return HeldOrdersResponse object
     */
    @GetMapping("/{id}")
    public HeldOrdersResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create a new HeldOrders record.
     * 
     * @param request DTO containing the HeldOrders data
     * @return Created HeldOrdersResponse
     */
    @PostMapping
    public HeldOrdersResponse create(@RequestBody @Valid HeldOrdersRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing HeldOrders by its ID.
     * 
     * @param id      ID of the HeldOrders to update
     * @param request DTO containing updated data
     * @return Updated HeldOrdersResponse
     */
    @PutMapping("/{id}")
    public HeldOrdersResponse update(@PathVariable Long id, @RequestBody @Valid HeldOrdersRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a HeldOrders by its ID.
     * 
     * @param id ID of the HeldOrders to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
