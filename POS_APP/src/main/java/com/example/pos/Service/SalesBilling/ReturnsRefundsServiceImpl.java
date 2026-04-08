package com.example.pos.Service.SalesBilling;

import com.example.pos.Entity.SalesBilling.ReturnsRefunds;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReturnsRefundsServiceImpl implements ReturnsRefundsService {

    @Override
    public List<ReturnsRefunds> all() {
        return List.of();
    }

    @Override
    public List<ReturnsRefunds> index() {
        return List.of();
    }

    @Override
    public Optional<ReturnsRefunds> show(Long id) {
        return Optional.empty();
    }

    @Override
    public ReturnsRefunds store(ReturnsRefunds entity) {
        return entity;
    }

    @Override
    public ReturnsRefunds update(Long id, ReturnsRefunds entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
