package com.example.pos.Service.Hardware;

import com.example.pos.Entity.Hardware.QRMobilePay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QRMobilePayServiceImpl implements QRMobilePayService {

    @Override
    public List<QRMobilePay> all() {
        return List.of();
    }

    @Override
    public List<QRMobilePay> index() {
        return List.of();
    }

    @Override
    public Optional<QRMobilePay> show(Long id) {
        return Optional.empty();
    }

    @Override
    public QRMobilePay store(QRMobilePay entity) {
        return entity;
    }

    @Override
    public QRMobilePay update(Long id, QRMobilePay entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
