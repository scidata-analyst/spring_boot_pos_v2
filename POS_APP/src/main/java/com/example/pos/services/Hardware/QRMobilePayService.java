package com.example.pos.services.Hardware;

import com.example.pos.dtos.request.Hardware.QRMobilePayRequest;
import com.example.pos.dtos.response.Hardware.QRMobilePayResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: QRMobilePay
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all() -> get all records
 * - index() -> UI listing (paginated later if needed)
 * - view() -> single record view
 * - create() -> create new record
 * - update() -> update existing record
 * - delete() -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface QRMobilePayService {

    List<QRMobilePayResponse> all();

    List<QRMobilePayResponse> index();

    QRMobilePayResponse view(Long id);

    QRMobilePayResponse create(QRMobilePayRequest request);

    QRMobilePayResponse update(Long id, QRMobilePayRequest request);

    void delete(Long id);
}
