package com.example.pos.Service.CustomersCRM;

import com.example.pos.Entity.CustomersCRM.CustomerDirectory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDirectoryServiceImpl implements CustomerDirectoryService {

    @Override
    public List<CustomerDirectory> all() {
        return List.of();
    }

    @Override
    public List<CustomerDirectory> index() {
        return List.of();
    }

    @Override
    public Optional<CustomerDirectory> show(Long id) {
        return Optional.empty();
    }

    @Override
    public CustomerDirectory store(CustomerDirectory entity) {
        return entity;
    }

    @Override
    public CustomerDirectory update(Long id, CustomerDirectory entity) {
        return entity;
    }

    @Override
    public void destroy(Long id) {
    }
}
