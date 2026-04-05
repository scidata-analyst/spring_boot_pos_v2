package com.scidata_analyst.pos.service.inventory;

import com.scidata_analyst.pos.dto.inventory.InventoryDTO;
import com.scidata_analyst.pos.dto.inventory.InventoryLogDTO;
import com.scidata_analyst.pos.dto.inventory.InventorySummaryDTO;
import com.scidata_analyst.pos.request.inventory.AdjustInventoryRequest;
import com.scidata_analyst.pos.request.inventory.LowStockAlertRequest;
import com.scidata_analyst.pos.request.inventory.SearchInventoryRequest;
import com.scidata_analyst.pos.response.inventory.InventoryAdjustResponse;
import com.scidata_analyst.pos.response.inventory.LowStockAlertResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface InventoryService {

    InventoryAdjustResponse adjustInventory(AdjustInventoryRequest request);

    Page<InventoryLogDTO> searchInventoryLogs(SearchInventoryRequest request);

    List<LowStockAlertResponse> getLowStockAlerts(LowStockAlertRequest request);

    InventorySummaryDTO getInventorySummary();

    InventoryDTO getInventoryByProductId(Long productId);

    List<InventoryDTO> getAllInventoryLevels();

    InventoryLogDTO getInventoryLogById(Long id);

    void recordStockMovement(Long productId, Integer quantityChange, String type, String notes);

    List<InventoryLogDTO> getProductInventoryLogs(Long productId);

    Page<InventoryLogDTO> getProductInventoryLogsPage(Long productId, Integer page, Integer size);

    List<InventoryDTO> getInventoryByCategory(Long categoryId);

    List<InventoryDTO> getInventoryBySupplier(Long supplierId);

    Map<String, Object> getInventoryValueSummary();

    List<InventoryAdjustResponse> bulkAdjustInventory(List<AdjustInventoryRequest> requests);
}
