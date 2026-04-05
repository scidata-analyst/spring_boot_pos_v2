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

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryControllerImpl implements InventoryController {

    private final InventoryService inventoryService;

    @Override
    @PostMapping("/adjust")
    public ResponseEntity<InventoryAdjustResponse> adjustInventory(@Valid @RequestBody AdjustInventoryRequest request) {
        InventoryAdjustResponse response = inventoryService.adjustInventory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/logs")
    public ResponseEntity<Page<InventoryLogDTO>> searchInventoryLogs(SearchInventoryRequest request) {
        Page<InventoryLogDTO> logs = inventoryService.searchInventoryLogs(request);
        return ResponseEntity.ok(logs);
    }

    @Override
    @GetMapping("/low-stock")
    public ResponseEntity<List<LowStockAlertResponse>> getLowStockAlerts(LowStockAlertRequest request) {
        List<LowStockAlertResponse> alerts = inventoryService.getLowStockAlerts(request);
        return ResponseEntity.ok(alerts);
    }

    @Override
    @GetMapping("/summary")
    public ResponseEntity<InventorySummaryDTO> getInventorySummary() {
        InventorySummaryDTO summary = inventoryService.getInventorySummary();
        return ResponseEntity.ok(summary);
    }

    @Override
    @GetMapping("/product/{productId}")
    public ResponseEntity<InventoryDTO> getInventoryByProductId(@PathVariable Long productId) {
        InventoryDTO inventory = inventoryService.getInventoryByProductId(productId);
        return ResponseEntity.ok(inventory);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<InventoryDTO>> getAllInventoryLevels() {
        List<InventoryDTO> inventory = inventoryService.getAllInventoryLevels();
        return ResponseEntity.ok(inventory);
    }

    @Override
    @GetMapping("/logs/{id}")
    public ResponseEntity<InventoryLogDTO> getInventoryLogById(@PathVariable Long id) {
        InventoryLogDTO log = inventoryService.getInventoryLogById(id);
        return ResponseEntity.ok(log);
    }
}
