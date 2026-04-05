package com.scidata_analyst.pos.service.supplier;

import com.scidata_analyst.pos.dto.product.ProductDTO;
import com.scidata_analyst.pos.dto.supplier.SupplierDTO;
import com.scidata_analyst.pos.dto.supplier.SupplierProductDTO;
import com.scidata_analyst.pos.entity.Product;
import com.scidata_analyst.pos.entity.Supplier;
import com.scidata_analyst.pos.repository.product.ProductRepository;
import com.scidata_analyst.pos.repository.supplier.SupplierRepository;
import com.scidata_analyst.pos.request.supplier.CreateSupplierRequest;
import com.scidata_analyst.pos.request.supplier.SearchSupplierRequest;
import com.scidata_analyst.pos.request.supplier.UpdateSupplierRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;

    @Override
    public SupplierDTO createSupplier(CreateSupplierRequest request) {
        if (request.getEmail() != null && supplierRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Supplier with email " + request.getEmail() + " already exists");
        }

        Supplier supplier = Supplier.builder()
                .name(request.getName())
                .contactPerson(request.getContactPerson())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .city(request.getCity())
                .state(request.getState())
                .zipCode(request.getZipCode())
                .taxNumber(request.getTaxNumber())
                .build();

        Supplier saved = supplierRepository.save(supplier);
        return mapToDTO(saved);
    }

    @Override
    public SupplierDTO updateSupplier(Long id, UpdateSupplierRequest request) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + id));

        if (request.getName() != null) supplier.setName(request.getName());
        if (request.getContactPerson() != null) supplier.setContactPerson(request.getContactPerson());
        if (request.getEmail() != null) {
            if (!supplier.getEmail().equals(request.getEmail()) && supplierRepository.existsByEmail(request.getEmail())) {
                throw new IllegalArgumentException("Supplier with email " + request.getEmail() + " already exists");
            }
            supplier.setEmail(request.getEmail());
        }
        if (request.getPhone() != null) supplier.setPhone(request.getPhone());
        if (request.getAddress() != null) supplier.setAddress(request.getAddress());
        if (request.getCity() != null) supplier.setCity(request.getCity());
        if (request.getState() != null) supplier.setState(request.getState());
        if (request.getZipCode() != null) supplier.setZipCode(request.getZipCode());
        if (request.getTaxNumber() != null) supplier.setTaxNumber(request.getTaxNumber());
        if (request.getIsActive() != null) supplier.setIsActive(request.getIsActive());

        Supplier updated = supplierRepository.save(supplier);
        return mapToDTO(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public SupplierDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + id));
        return mapToDTO(supplier);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SupplierDTO> searchSuppliers(SearchSupplierRequest request) {
        Sort sort = Sort.by(Sort.Direction.fromString(request.getSortDir()), request.getSortBy());
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        Page<Supplier> suppliers = supplierRepository.searchSuppliers(
                request.getKeyword(),
                request.getEmail(),
                request.getPhone(),
                request.getIsActive(),
                pageable
        );

        return suppliers.map(this::mapToDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SupplierDTO> getAllActiveSuppliers() {
        return supplierRepository.findByIsActiveTrue(PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SupplierProductDTO getSupplierProducts(Long supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + supplierId));

        List<Product> products = productRepository.findBySupplierId(supplierId, PageRequest.of(0, Integer.MAX_VALUE)).getContent();

        long totalProducts = products.size();
        long activeProducts = products.stream().filter(Product::getIsActive).count();

        BigDecimal totalStockValue = products.stream()
                .map(p -> p.getCostPrice() != null ? p.getCostPrice().multiply(BigDecimal.valueOf(p.getStockQuantity())) : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal averageCostPrice = products.stream()
                .map(Product::getCostPrice)
                .filter(cp -> cp != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(totalProducts > 0 ? BigDecimal.valueOf(totalProducts) : BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);

        return SupplierProductDTO.builder()
                .supplierId(supplier.getId())
                .supplierName(supplier.getName())
                .contactPerson(supplier.getContactPerson())
                .phone(supplier.getPhone())
                .totalProducts(totalProducts)
                .activeProducts(activeProducts)
                .totalStockValue(totalStockValue)
                .averageCostPrice(averageCostPrice)
                .build();
    }

    @Override
    public void deleteSupplier(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new EntityNotFoundException("Supplier not found with id: " + id);
        }
        supplierRepository.deleteById(id);
    }

    @Override
    public void deactivateSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + id));
        supplier.setIsActive(false);
        supplierRepository.save(supplier);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return supplierRepository.existsByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public SupplierDTO getSupplierByName(String name) {
        Supplier supplier = supplierRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with name: " + name));
        return mapToDTO(supplier);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getSupplierProductsList(Long supplierId) {
        return productRepository.findBySupplierId(supplierId, PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getSupplierActiveProducts(Long supplierId) {
        return productRepository.findBySupplierId(supplierId, PageRequest.of(0, Integer.MAX_VALUE))
                .getContent()
                .stream()
                .filter(Product::getIsActive)
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Long getSupplierProductCount(Long supplierId) {
        return (long) productRepository.findBySupplierId(supplierId, PageRequest.of(0, Integer.MAX_VALUE)).getContent().size();
    }

    private SupplierDTO mapToDTO(Supplier supplier) {
        long productCount = supplier.getProducts() != null ? supplier.getProducts().size() : 0;

        return SupplierDTO.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .contactPerson(supplier.getContactPerson())
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .address(supplier.getAddress())
                .city(supplier.getCity())
                .state(supplier.getState())
                .zipCode(supplier.getZipCode())
                .taxNumber(supplier.getTaxNumber())
                .isActive(supplier.getIsActive())
                .productCount(productCount)
                .build();
    }

    private ProductDTO mapProductToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .barcode(product.getBarcode())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .costPrice(product.getCostPrice())
                .stockQuantity(product.getStockQuantity())
                .reorderLevel(product.getReorderLevel())
                .isActive(product.getIsActive())
                .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                .categoryName(product.getCategory() != null ? product.getCategory().getName() : null)
                .supplierId(product.getSupplier() != null ? product.getSupplier().getId() : null)
                .supplierName(product.getSupplier() != null ? product.getSupplier().getName() : null)
                .build();
    }
}
