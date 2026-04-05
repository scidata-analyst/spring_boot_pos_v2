package com.scidata_analyst.pos.controller.supplier;

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
public class SupplierControllerImpl implements SupplierController {

    private final SupplierService supplierService;

    @Override
    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@Valid @RequestBody CreateSupplierRequest request) {
        SupplierDTO created = supplierService.createSupplier(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @Valid @RequestBody UpdateSupplierRequest request) {
        SupplierDTO updated = supplierService.updateSupplier(id, request);
        return ResponseEntity.ok(updated);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        SupplierDTO supplier = supplierService.getSupplierById(id);
        return ResponseEntity.ok(supplier);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<SupplierDTO>> searchSuppliers(SearchSupplierRequest request) {
        Page<SupplierDTO> suppliers = supplierService.searchSuppliers(request);
        return ResponseEntity.ok(suppliers);
    }

    @Override
    @GetMapping("/active")
    public ResponseEntity<List<SupplierDTO>> getAllActiveSuppliers() {
        List<SupplierDTO> suppliers = supplierService.getAllActiveSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @Override
    @GetMapping("/{supplierId}/products")
    public ResponseEntity<SupplierProductDTO> getSupplierProducts(@PathVariable Long supplierId) {
        SupplierProductDTO products = supplierService.getSupplierProducts(supplierId);
        return ResponseEntity.ok(products);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateSupplier(@PathVariable Long id) {
        supplierService.deactivateSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
