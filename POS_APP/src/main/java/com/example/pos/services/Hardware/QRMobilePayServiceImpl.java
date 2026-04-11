package com.example.pos.services.Hardware;

import com.example.pos.entities.Hardware.QRMobilePay;
import com.example.pos.dtos.request.Hardware.QRMobilePayRequest;
import com.example.pos.dtos.response.Hardware.QRMobilePayResponse;
import com.example.pos.mappers.Hardware.QRMobilePayMapper;
import com.example.pos.repositories.Hardware.QRMobilePayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for QRMobilePay.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class QRMobilePayServiceImpl implements QRMobilePayService {

    @Autowired
    private QRMobilePayRepository repository;

    @Autowired
    private QRMobilePayMapper mapper;

    @Override
    public List<QRMobilePayResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<QRMobilePayResponse> index() {
        return repository.index()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public QRMobilePayResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public QRMobilePayResponse create(QRMobilePayRequest request) {
        QRMobilePay entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public QRMobilePayResponse update(Long id, QRMobilePayRequest request) {

        QRMobilePay existing = repository.view(id).orElse(null);

        if (existing == null)
            return null;

        mapper.updateEntity(request, existing);

        return mapper.toResponse(repository.update(existing));
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
