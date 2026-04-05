package com.scidata_analyst.pos.service.product;

import com.scidata_analyst.pos.dto.product.ProductDTO;
import com.scidata_analyst.pos.dto.product.ProductPriceDTO;
import com.scidata_analyst.pos.dto.product.ProductStockDTO;
import com.scidata_analyst.pos.request.product.CreateProductRequest;
import com.scidata_analyst.pos.request.product.SearchProductRequest;
import com.scidata_analyst.pos.request.product.UpdateProductRequest;
import com.scidata_analyst.pos.request.product.UpdateStockRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(CreateProductRequest request);

    ProductDTO updateProduct(Long id, UpdateProductRequest request);

    ProductDTO getProductById(Long id);

    ProductDTO getProductByBarcode(String barcode);

    Page<ProductDTO> searchProducts(SearchProductRequest request);

    List<ProductDTO> getAllActiveProducts();

    ProductStockDTO updateStock(UpdateStockRequest request);

    ProductPriceDTO updatePrice(Long id, ProductPriceDTO priceDTO);

    void deleteProduct(Long id);

    void deactivateProduct(Long id);

    boolean existsByBarcode(String barcode);

    ProductStockDTO getProductStock(Long id);

    List<ProductDTO> getLowStockProducts(Integer threshold);

    List<ProductDTO> getProductsByCategory(Long categoryId);

    List<ProductDTO> getProductsBySupplier(Long supplierId);

    ProductDTO assignToCategory(Long productId, Long categoryId);

    ProductDTO assignToSupplier(Long productId, Long supplierId);

    ProductDTO removeFromCategory(Long productId);

    ProductDTO removeFromSupplier(Long productId);
}
