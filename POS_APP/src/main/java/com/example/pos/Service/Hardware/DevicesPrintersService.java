package com.example.pos.Service.Hardware;

import com.example.pos.Entity.Hardware.DevicesPrinters;
import java.util.List;
import java.util.Optional;

public interface DevicesPrintersService {
    List<DevicesPrinters> all();
    List<DevicesPrinters> index();
    Optional<DevicesPrinters> show(Long id);
    DevicesPrinters store(DevicesPrinters entity);
    DevicesPrinters update(Long id, DevicesPrinters entity);
    void destroy(Long id);
}
