package com.example.pos.Service.PaymentAccounting;

import com.example.pos.Entity.PaymentAccounting.TaxReports;
import java.util.List;
import java.util.Optional;

public interface TaxReportsService {
    List<TaxReports> all();
    List<TaxReports> index();
    Optional<TaxReports> show(Long id);
    TaxReports store(TaxReports entity);
    TaxReports update(Long id, TaxReports entity);
    void destroy(Long id);
}
