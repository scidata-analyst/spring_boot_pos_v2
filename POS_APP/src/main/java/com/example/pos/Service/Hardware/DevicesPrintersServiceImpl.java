package com.example.pos.Service.Hardware;

import com.example.pos.Entity.Hardware.DevicesPrinters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DevicesPrintersServiceImpl implements DevicesPrintersService {

    @Override
    public List<DevicesPrinters> all() {
        return List.of();
    }

    @Override
    public List<DevicesPrinters> index() {
        return List.of();
    }

    @Override
    public Optional<DevicesPrinters> show(Long id) {
        return Optional.empty();
    }

    @Override
    public DevicesPrinters store(DevicesPrinters entity) {
        return entity;
    }

    @Override
    public DevicesPrinters update(Long id, DevicesPrinters entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
