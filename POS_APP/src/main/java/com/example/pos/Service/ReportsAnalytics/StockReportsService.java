package com.example.pos.Service.ReportsAnalytics;

import com.example.pos.Entity.ReportsAnalytics.StockReports;
import java.util.List;
import java.util.Optional;

public interface StockReportsService {
    List<StockReports> all();
    List<StockReports> index();
    Optional<StockReports> show(Long id);
    StockReports store(StockReports entity);
    void destroy(Long id);
}
