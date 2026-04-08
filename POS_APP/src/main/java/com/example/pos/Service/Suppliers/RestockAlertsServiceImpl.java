package com.example.pos.Service.Suppliers;

import com.example.pos.Entity.Suppliers.RestockAlerts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestockAlertsServiceImpl implements RestockAlertsService {

    @Override
    public List<RestockAlerts> all() {
        return List.of();
    }

    @Override
    public List<RestockAlerts> index() {
        return List.of();
    }

    @Override
    public Optional<RestockAlerts> show(Long id) {
        return Optional.empty();
    }

    @Override
    public RestockAlerts store(RestockAlerts entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
