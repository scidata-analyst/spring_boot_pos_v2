package com.example.pos.Service.ReportsAnalytics;

import com.example.pos.Entity.ReportsAnalytics.SalesReports;
import java.util.List;
import java.util.Optional;

public interface SalesReportsService {
    List<SalesReports> all();
    List<SalesReports> index();
    Optional<SalesReports> show(Long id);
    SalesReports store(SalesReports entity);
    void destroy(Long id);
}
