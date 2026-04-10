package com.example.pos.controllers.Hardware;

import com.example.pos.dtos.request.Hardware.QrMobileRequest;
import com.example.pos.dtos.response.Hardware.QrMobileResponse;
import com.example.pos.services.Hardware.QrMobileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing QrMobile operations.
 * Provides standard CRUD endpoints for QrMobile.
 * All responses are returned using QrMobileResponse DTO.
 */
@RestController
@RequestMapping("/api/Hardware/QrMobile")
public class QrMobileController {

    @Autowired
    private QrMobileService service;

    /**
     * Retrieve all QrMobile records.
     * 
     * @return List of QrMobileResponse
     */
    @GetMapping
    public List<QrMobileResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single QrMobile by its ID.
     * 
     * @param id ID of the QrMobile
     * @return QrMobileResponse object
     */
    @GetMapping("/{id}")
    public QrMobileResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Create a new QrMobile record.
     * 
     * @param request DTO containing the QrMobile data
     * @return Created QrMobileResponse
     */
    @PostMapping
    public QrMobileResponse create(@RequestBody @Valid QrMobileRequest request) {
        return service.create(request);
    }

    /**
     * Update an existing QrMobile by its ID.
     * 
     * @param id      ID of the QrMobile to update
     * @param request DTO containing updated data
     * @return Updated QrMobileResponse
     */
    @PutMapping("/{id}")
    public QrMobileResponse update(@PathVariable Long id, @RequestBody @Valid QrMobileRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a QrMobile by its ID.
     * 
     * @param id ID of the QrMobile to delete
     * @return Success message
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
