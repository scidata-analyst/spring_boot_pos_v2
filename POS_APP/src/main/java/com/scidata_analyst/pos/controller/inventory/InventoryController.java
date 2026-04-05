package com.scidata_analyst.pos.controller.inventory;

import com.scidata_analyst.pos.dto.inventory.InventoryDTO;
import com.scidata_analyst.pos.dto.inventory.InventoryLogDTO;
import com.scidata_analyst.pos.dto.inventory.InventorySummaryDTO;
import com.scidata_analyst.pos.request.inventory.AdjustInventoryRequest;
import com.scidata_analyst.pos.request.inventory.LowStockAlertRequest;
import com.scidata_analyst.pos.request.inventory.SearchInventoryRequest;
import com.scidata_analyst.pos.response.inventory.InventoryAdjustResponse;
import com.scidata_analyst.pos.response.inventory.LowStockAlertResponse;
import com.scidata_analyst.pos.service.inventory.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/adjust")
    public ResponseEntity<InventoryAdjustResponse> adjustInventory(@Valid @RequestBody AdjustInventoryRequest request) {
        InventoryAdjustResponse response = inventoryService.adjustInventory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/logs")
    public ResponseEntity<Page<InventoryLogDTO>> searchInventoryLogs(SearchInventoryRequest request) {
        Page<InventoryLogDTO> logs = inventoryService.searchInventoryLogs(request);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<LowStockAlertResponse>> getLowStockAlerts(LowStockAlertRequest request) {
        List<LowStockAlertResponse> alerts = inventoryService.getLowStockAlerts(request);
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/summary")
    public ResponseEntity<InventorySummaryDTO> getInventorySummary() {
        InventorySummaryDTO summary = inventoryService.getInventorySummary();
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<InventoryDTO> getInventoryByProductId(@PathVariable Long productId) {
        InventoryDTO inventory = inventoryService.getInventoryByProductId(productId);
        return ResponseEntity.ok(inventory);
    }

    @GetMapping("/all")
    public ResponseEntity<List<InventoryDTO>> getAllInventoryLevels() {
        List<InventoryDTO> inventory = inventoryService.getAllInventoryLevels();
        return ResponseEntity.ok(inventory);
    }

    @GetMapping("/logs/{id}")
    public ResponseEntity<InventoryLogDTO> getInventoryLogById(@PathVariable Long id) {
        InventoryLogDTO log = inventoryService.getInventoryLogById(id);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/product/{productId}/logs")
    public ResponseEntity<List<InventoryLogDTO>> getProductInventoryLogs(@PathVariable Long productId) {
        List<InventoryLogDTO> logs = inventoryService.getProductInventoryLogs(productId);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/product/{productId}/logs/page")
    public ResponseEntity<Page<InventoryLogDTO>> getProductInventoryLogsPage(
            @PathVariable Long productId,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        Page<InventoryLogDTO> logs = inventoryService.getProductInventoryLogsPage(productId, page, size);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<InventoryDTO>> getInventoryByCategory(@PathVariable Long categoryId) {
        List<InventoryDTO> inventory = inventoryService.getInventoryByCategory(categoryId);
        return ResponseEntity.ok(inventory);
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<InventoryDTO>> getInventoryBySupplier(@PathVariable Long supplierId) {
        List<InventoryDTO> inventory = inventoryService.getInventoryBySupplier(supplierId);
        return ResponseEntity.ok(inventory);
    }

    @GetMapping("/value-summary")
    public ResponseEntity<Map<String, Object>> getInventoryValueSummary() {
        Map<String, Object> summary = inventoryService.getInventoryValueSummary();
        return ResponseEntity.ok(summary);
    }

    @PostMapping("/bulk-adjust")
    public ResponseEntity<List<InventoryAdjustResponse>> bulkAdjustInventory(@Valid @RequestBody List<AdjustInventoryRequest> requests) {
        List<InventoryAdjustResponse> responses = inventoryService.bulkAdjustInventory(requests);
        return ResponseEntity.status(HttpStatus.CREATED).body(responses);
    }
}
