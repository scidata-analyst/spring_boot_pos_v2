package com.example.pos.Service.Promotions;

import com.example.pos.Entity.Promotions.OffersCombos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OffersCombosServiceImpl implements OffersCombosService {

    @Override
    public List<OffersCombos> all() {
        return List.of();
    }

    @Override
    public List<OffersCombos> index() {
        return List.of();
    }

    @Override
    public Optional<OffersCombos> show(Long id) {
        return Optional.empty();
    }

    @Override
    public OffersCombos store(OffersCombos entity) {
        return entity;
    }

    @Override
    public OffersCombos update(Long id, OffersCombos entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
