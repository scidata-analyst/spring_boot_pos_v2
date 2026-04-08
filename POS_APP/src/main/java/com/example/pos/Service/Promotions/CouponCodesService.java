package com.example.pos.Service.Promotions;

import com.example.pos.Entity.Promotions.CouponCodes;
import java.util.List;
import java.util.Optional;

public interface CouponCodesService {
    List<CouponCodes> all();
    List<CouponCodes> index();
    Optional<CouponCodes> show(Long id);
    CouponCodes store(CouponCodes entity);
    CouponCodes update(Long id, CouponCodes entity);
    void destroy(Long id);
}
