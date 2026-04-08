package com.example.pos.Service.Promotions;

import com.example.pos.Entity.Promotions.OffersCombos;
import java.util.List;
import java.util.Optional;

public interface OffersCombosService {
    List<OffersCombos> all();
    List<OffersCombos> index();
    Optional<OffersCombos> show(Long id);
    OffersCombos store(OffersCombos entity);
    OffersCombos update(Long id, OffersCombos entity);
    void destroy(Long id);
}
