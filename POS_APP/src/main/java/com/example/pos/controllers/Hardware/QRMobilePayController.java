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
 * Provides standard CRUD APIs for QRMobilePay.
 * All responses are returned using QRMobilePayResponse DTO.
 *
 * Endpoints:
 * - GET    /api/Hardware/QRMobilePay
 * - GET    /api/Hardware/QRMobilePay/{id}
 * - POST   /api/Hardware/QRMobilePay
 * - PUT    /api/Hardware/QRMobilePay/{id}
 * - DELETE /api/Hardware/QRMobilePay/{id}
 */
@RestController
@RequestMapping("/api/Hardware/QRMobilePay")
public class QRMobilePayController {

    @Autowired
    private QRMobilePayService service;

    /**
     * Retrieve all QRMobilePay records.
     *
     * @return List of QRMobilePayResponse
     */
    @GetMapping
    public List<QRMobilePayResponse> getAll() {
        return service.getAll();
    }

    /**
     * Retrieve a single QRMobilePay by ID.
     *
     * @param id ID of the QRMobilePay
     * @return QRMobilePayResponse
     */
    @GetMapping("/{id}")
    public QRMobilePayResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Create new QRMobilePay record.
     *
     * @param request request DTO
     * @return created QRMobilePayResponse
     */
    @PostMapping
    public QRMobilePayResponse create(@RequestBody @Valid QRMobilePayRequest request) {
        return service.create(request);
    }

    /**
     * Update existing QRMobilePay record.
     *
     * @param id      record ID
     * @param request updated data
     * @return updated QRMobilePayResponse
     */
    @PutMapping("/{id}")
    public QRMobilePayResponse update(@PathVariable Long id,
                                         @RequestBody @Valid QRMobilePayRequest request) {
        return service.update(id, request);
    }

    /**
     * Delete a QRMobilePay record.
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
