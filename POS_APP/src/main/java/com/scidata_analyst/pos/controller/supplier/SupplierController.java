package com.scidata_analyst.pos.controller.supplier;

import com.scidata_analyst.pos.dto.product.ProductDTO;
import com.scidata_analyst.pos.dto.supplier.SupplierDTO;
import com.scidata_analyst.pos.dto.supplier.SupplierProductDTO;
import com.scidata_analyst.pos.request.supplier.CreateSupplierRequest;
import com.scidata_analyst.pos.request.supplier.SearchSupplierRequest;
import com.scidata_analyst.pos.request.supplier.UpdateSupplierRequest;
import com.scidata_analyst.pos.service.supplier.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@Valid @RequestBody CreateSupplierRequest request) {
        SupplierDTO created = supplierService.createSupplier(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @Valid @RequestBody UpdateSupplierRequest request) {
        SupplierDTO updated = supplierService.updateSupplier(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        SupplierDTO supplier = supplierService.getSupplierById(id);
        return ResponseEntity.ok(supplier);
    }

    @GetMapping
    public ResponseEntity<Page<SupplierDTO>> searchSuppliers(SearchSupplierRequest request) {
        Page<SupplierDTO> suppliers = supplierService.searchSuppliers(request);
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/active")
    public ResponseEntity<List<SupplierDTO>> getAllActiveSuppliers() {
        List<SupplierDTO> suppliers = supplierService.getAllActiveSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{supplierId}/products")
    public ResponseEntity<SupplierProductDTO> getSupplierProducts(@PathVariable Long supplierId) {
        SupplierProductDTO products = supplierService.getSupplierProducts(supplierId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}/products/list")
    public ResponseEntity<List<ProductDTO>> getSupplierProductsList(@PathVariable Long id) {
        List<ProductDTO> products = supplierService.getSupplierProductsList(id);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}/products/active")
    public ResponseEntity<List<ProductDTO>> getSupplierActiveProducts(@PathVariable Long id) {
        List<ProductDTO> products = supplierService.getSupplierActiveProducts(id);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}/products/count")
    public ResponseEntity<Long> getSupplierProductCount(@PathVariable Long id) {
        Long count = supplierService.getSupplierProductCount(id);
        return ResponseEntity.ok(count);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateSupplier(@PathVariable Long id) {
        supplierService.deactivateSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
