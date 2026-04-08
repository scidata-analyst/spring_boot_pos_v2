package com.example.pos.Service.Hardware;

import com.example.pos.Entity.Hardware.CashDrawer;
import java.util.List;
import java.util.Optional;

public interface CashDrawerService {
    List<CashDrawer> all();
    List<CashDrawer> index();
    Optional<CashDrawer> show(Long id);
    CashDrawer store(CashDrawer entity);
    CashDrawer update(Long id, CashDrawer entity);
    void destroy(Long id);
}
