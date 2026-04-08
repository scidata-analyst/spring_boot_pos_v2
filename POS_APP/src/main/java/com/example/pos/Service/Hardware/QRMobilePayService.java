package com.example.pos.Service.Hardware;

import com.example.pos.Entity.Hardware.QRMobilePay;
import java.util.List;
import java.util.Optional;

public interface QRMobilePayService {
    List<QRMobilePay> all();
    List<QRMobilePay> index();
    Optional<QRMobilePay> show(Long id);
    QRMobilePay store(QRMobilePay entity);
    QRMobilePay update(Long id, QRMobilePay entity);
    void destroy(Long id);
}
