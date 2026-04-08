package com.example.pos.Service.Suppliers;

import com.example.pos.Entity.Suppliers.RestockAlerts;
import java.util.List;
import java.util.Optional;

public interface RestockAlertsService {
    List<RestockAlerts> all();
    List<RestockAlerts> index();
    Optional<RestockAlerts> show(Long id);
    RestockAlerts store(RestockAlerts entity);
    void destroy(Long id);
}
