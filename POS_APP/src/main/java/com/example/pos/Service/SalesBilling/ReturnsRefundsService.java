package com.example.pos.Service.SalesBilling;

import com.example.pos.Entity.SalesBilling.ReturnsRefunds;
import java.util.List;
import java.util.Optional;

public interface ReturnsRefundsService {
    List<ReturnsRefunds> all();
    List<ReturnsRefunds> index();
    Optional<ReturnsRefunds> show(Long id);
    ReturnsRefunds store(ReturnsRefunds entity);
    ReturnsRefunds update(Long id, ReturnsRefunds entity);
    void destroy(Long id);
}
