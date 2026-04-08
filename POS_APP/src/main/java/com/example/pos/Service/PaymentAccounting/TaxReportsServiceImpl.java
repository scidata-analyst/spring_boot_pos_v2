package com.example.pos.Service.PaymentAccounting;

import com.example.pos.Entity.PaymentAccounting.TaxReports;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaxReportsServiceImpl implements TaxReportsService {

    @Override
    public List<TaxReports> all() {
        return List.of();
    }

    @Override
    public List<TaxReports> index() {
        return List.of();
    }

    @Override
    public Optional<TaxReports> show(Long id) {
        return Optional.empty();
    }

    @Override
    public TaxReports store(TaxReports entity) {
        return entity;
    }

    @Override
    public TaxReports update(Long id, TaxReports entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
