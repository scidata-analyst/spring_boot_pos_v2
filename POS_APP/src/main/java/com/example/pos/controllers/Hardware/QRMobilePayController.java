package com.example.pos.controllers.Hardware;

import com.example.pos.dtos.request.Hardware.QRMobilePayRequest;
import com.example.pos.dtos.response.Hardware.QRMobilePayResponse;
import com.example.pos.services.Hardware.QRMobilePayService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * =====================================================
 * REST Controller: QRMobilePay
 * =====================================================
 *
 * Provides standard REST APIs for QRMobilePay.
 * Uses repository-semantic service methods:
 * all, index, view, create, update, delete.
 */
@RestController
@RequestMapping("/api/Hardware/QRMobilePay")
public class QRMobilePayController {

    @Autowired
    private QRMobilePayService service;

    /**
     * Get all records.
     */
    @GetMapping("/all")
    public List<QRMobilePayResponse> all() {
        return service.all();
    }

    /**
     * Get paginated/index data.
     */
    @GetMapping("/index")
    public List<QRMobilePayResponse> index() {
        return service.index();
    }

    /**
     * View single record.
     */
    @GetMapping("/view/{id}")
    public QRMobilePayResponse view(@PathVariable Long id) {
        return service.view(id);
    }

    /**
     * Create new record.
     */
    @PostMapping("/create")
    public QRMobilePayResponse create(@RequestBody @Valid QRMobilePayRequest request) {
        return service.create(request);
    }

    /**
     * Update existing record.
     */
    @PutMapping("/update/{id}")
    public QRMobilePayResponse update(@PathVariable Long id,
            @RequestBody @Valid QRMobilePayRequest request) {
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
