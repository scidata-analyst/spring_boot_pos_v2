package com.example.pos.Service.Hardware;

import com.example.pos.Entity.Hardware.CashDrawer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CashDrawerServiceImpl implements CashDrawerService {

    @Override
    public List<CashDrawer> all() {
        return List.of();
    }

    @Override
    public List<CashDrawer> index() {
        return List.of();
    }

    @Override
    public Optional<CashDrawer> show(Long id) {
        return Optional.empty();
    }

    @Override
    public CashDrawer store(CashDrawer entity) {
        return entity;
    }

    @Override
    public CashDrawer update(Long id, CashDrawer entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
