package com.scidata_analyst.pos.controller.product;

import com.scidata_analyst.pos.dto.product.ProductDTO;
import com.scidata_analyst.pos.dto.product.ProductPriceDTO;
import com.scidata_analyst.pos.dto.product.ProductStockDTO;
import com.scidata_analyst.pos.request.product.CreateProductRequest;
import com.scidata_analyst.pos.request.product.SearchProductRequest;
import com.scidata_analyst.pos.request.product.UpdateProductRequest;
import com.scidata_analyst.pos.request.product.UpdateStockRequest;
import com.scidata_analyst.pos.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody CreateProductRequest request) {
        ProductDTO created = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody UpdateProductRequest request) {
        ProductDTO updated = productService.updateProduct(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/barcode/{barcode}")
    public ResponseEntity<ProductDTO> getProductByBarcode(@PathVariable String barcode) {
        ProductDTO product = productService.getProductByBarcode(barcode);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> searchProducts(SearchProductRequest request) {
        Page<ProductDTO> products = productService.searchProducts(request);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/active")
    public ResponseEntity<List<ProductDTO>> getAllActiveProducts() {
        List<ProductDTO> products = productService.getAllActiveProducts();
        return ResponseEntity.ok(products);
    }

    @PatchMapping("/stock")
    public ResponseEntity<ProductStockDTO> updateStock(@Valid @RequestBody UpdateStockRequest request) {
        ProductStockDTO stock = productService.updateStock(request);
        return ResponseEntity.ok(stock);
    }

    @PatchMapping("/{id}/price")
    public ResponseEntity<ProductPriceDTO> updatePrice(@PathVariable Long id, @Valid @RequestBody ProductPriceDTO priceDTO) {
        ProductPriceDTO updated = productService.updatePrice(id, priceDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateProduct(@PathVariable Long id) {
        productService.deactivateProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/stock")
    public ResponseEntity<ProductStockDTO> getProductStock(@PathVariable Long id) {
        ProductStockDTO stock = productService.getProductStock(id);
        return ResponseEntity.ok(stock);
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<ProductDTO>> getLowStockProducts(@RequestParam(defaultValue = "10") Integer threshold) {
        List<ProductDTO> products = productService.getLowStockProducts(threshold);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Long categoryId) {
        List<ProductDTO> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<ProductDTO>> getProductsBySupplier(@PathVariable Long supplierId) {
        List<ProductDTO> products = productService.getProductsBySupplier(supplierId);
        return ResponseEntity.ok(products);
    }

    @PatchMapping("/{id}/category/{categoryId}")
    public ResponseEntity<ProductDTO> assignProductToCategory(@PathVariable Long id, @PathVariable Long categoryId) {
        ProductDTO updated = productService.assignToCategory(id, categoryId);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}/supplier/{supplierId}")
    public ResponseEntity<ProductDTO> assignProductToSupplier(@PathVariable Long id, @PathVariable Long supplierId) {
        ProductDTO updated = productService.assignToSupplier(id, supplierId);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}/category")
    public ResponseEntity<ProductDTO> removeProductFromCategory(@PathVariable Long id) {
        ProductDTO updated = productService.removeFromCategory(id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}/supplier")
    public ResponseEntity<ProductDTO> removeProductFromSupplier(@PathVariable Long id) {
        ProductDTO updated = productService.removeFromSupplier(id);
        return ResponseEntity.ok(updated);
    }
}
