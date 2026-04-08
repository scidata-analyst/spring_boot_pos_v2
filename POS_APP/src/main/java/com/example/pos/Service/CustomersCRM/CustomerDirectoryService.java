package com.example.pos.Service.CustomersCRM;

import com.example.pos.Entity.CustomersCRM.CustomerDirectory;
import java.util.List;
import java.util.Optional;

public interface CustomerDirectoryService {
    List<CustomerDirectory> all();
    List<CustomerDirectory> index();
    Optional<CustomerDirectory> show(Long id);
    CustomerDirectory store(CustomerDirectory entity);
    CustomerDirectory update(Long id, CustomerDirectory entity);
    void destroy(Long id);
}
