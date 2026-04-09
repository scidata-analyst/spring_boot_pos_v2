package com.example.pos.services.Hardware;

import com.example.pos.dtos.request.Hardware.QrMobileRequest;
import com.example.pos.dtos.response.Hardware.QrMobileResponse;
import java.util.List;

/**
 * Service interface for QrMobile.
 * Defines standard CRUD operations for QrMobile, same as Controller methods.
 */
public interface QrMobileService {

    /**
     * Retrieve all QrMobile records.
     * @return List of QrMobileResponse
     */
    List<QrMobileResponse> getAll();

    /**
     * Retrieve a single QrMobile by its ID.
     * @param id ID of the QrMobile
     * @return QrMobileResponse object
     */
    QrMobileResponse get(Long id);

    /**
     * Create a new QrMobile record.
     * @param request DTO containing the QrMobile data
     * @return Created QrMobileResponse
     */
    QrMobileResponse create(QrMobileRequest request);

    /**
     * Update an existing QrMobile by its ID.
     * @param id ID of the QrMobile to update
     * @param request DTO containing updated data
     * @return Updated QrMobileResponse
     */
    QrMobileResponse update(Long id, QrMobileRequest request);

    /**
     * Delete a QrMobile by its ID.
     * @param id ID of the QrMobile to delete
     */
    void delete(Long id);
}
