package com.example.pos.services.Hardware;

import com.example.pos.dtos.request.Hardware.DevicesPrintersRequest;
import com.example.pos.dtos.response.Hardware.DevicesPrintersResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: DevicesPrinters
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all()     -> get all records
 * - index()   -> UI listing (paginated later if needed)
 * - view()    -> single record view
 * - create()  -> create new record
 * - update()  -> update existing record
 * - delete()  -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface DevicesPrintersService {

    List<DevicesPrintersResponse> all();

    List<DevicesPrintersResponse> index();

    DevicesPrintersResponse view(Long id);

    DevicesPrintersResponse create(DevicesPrintersRequest request);

    DevicesPrintersResponse update(Long id, DevicesPrintersRequest request);

    void delete(Long id);
}
