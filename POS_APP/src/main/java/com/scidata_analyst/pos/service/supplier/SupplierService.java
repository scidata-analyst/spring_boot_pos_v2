package com.scidata_analyst.pos.service.supplier;

import com.scidata_analyst.pos.dto.product.ProductDTO;
import com.scidata_analyst.pos.dto.supplier.SupplierDTO;
import com.scidata_analyst.pos.dto.supplier.SupplierProductDTO;
import com.scidata_analyst.pos.request.supplier.CreateSupplierRequest;
import com.scidata_analyst.pos.request.supplier.SearchSupplierRequest;
import com.scidata_analyst.pos.request.supplier.UpdateSupplierRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService {

    SupplierDTO createSupplier(CreateSupplierRequest request);

    SupplierDTO updateSupplier(Long id, UpdateSupplierRequest request);

    SupplierDTO getSupplierById(Long id);

    Page<SupplierDTO> searchSuppliers(SearchSupplierRequest request);

    List<SupplierDTO> getAllActiveSuppliers();

    SupplierProductDTO getSupplierProducts(Long supplierId);

    void deleteSupplier(Long id);

    void deactivateSupplier(Long id);

    boolean existsByEmail(String email);

    SupplierDTO getSupplierByName(String name);

    List<ProductDTO> getSupplierProductsList(Long supplierId);

    List<ProductDTO> getSupplierActiveProducts(Long supplierId);

    Long getSupplierProductCount(Long supplierId);
}
