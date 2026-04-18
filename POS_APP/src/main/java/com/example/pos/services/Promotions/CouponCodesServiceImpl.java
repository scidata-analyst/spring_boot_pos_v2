package com.example.pos.services.Promotions;

import com.example.pos.entities.Promotions.CouponCodes;
import com.example.pos.dtos.request.Promotions.CouponCodesRequest;
import com.example.pos.dtos.response.Promotions.CouponCodesResponse;
import com.example.pos.mappers.Promotions.CouponCodesMapper;
import com.example.pos.repositories.Promotions.CouponCodesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for CouponCodes.
 * Uses repository semantic methods (no JPA direct calls).
 */
@Service
public class CouponCodesServiceImpl implements CouponCodesService {

    @Autowired
    private CouponCodesRepository repository;

    @Autowired
    private CouponCodesMapper mapper;

    @Override
    public List<CouponCodesResponse> all() {
        return repository.all()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public Page<CouponCodesResponse> index(String search, Pageable pageable) {
        return repository.index(search, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public CouponCodesResponse view(Long id) {
        return repository.view(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    @Override
    public CouponCodesResponse create(CouponCodesRequest request) {
        CouponCodes entity = mapper.toEntity(request);
        return mapper.toResponse(repository.create(entity));
    }

    @Override
    public CouponCodesResponse update(Long id, CouponCodesRequest request) {

        CouponCodes existing = repository.view(id).orElse(null);

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
