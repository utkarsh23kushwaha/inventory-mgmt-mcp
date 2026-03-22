package com.inventorymgmt.mcp.services;

import com.inventorymgmt.mcp.models.Material;
import com.inventorymgmt.mcp.models.enums.MaterialType;
import com.inventorymgmt.mcp.models.Stock;
import com.inventorymgmt.mcp.repositories.MaterialRepository;
import com.inventorymgmt.mcp.repositories.StockRepository;
import com.inventorymgmt.mcp.models.enums.Location;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final MaterialRepository materialRepository;
    private final StockRepository stockRepository;

    public InventoryService(MaterialRepository materialRepository, StockRepository stockRepository) {
        this.materialRepository = materialRepository;
        this.stockRepository = stockRepository;
    }

    public List<Material> getMaterialsByType(MaterialType type) {
        return materialRepository.findByType(type);
    }

    public List<Stock> getStocksByMaterialType(MaterialType type) {
        return stockRepository.findByMaterialType(type);
    }

    public List<Stock> getStocksByLocation(Location location) {
        return stockRepository.findByLocation(location);
    }

    public Optional<Stock> getStockByMaterialId(Long materialId) {
        return stockRepository.findByMaterialId(materialId).stream().findFirst();
    }

    @Transactional
    public Stock adjustStock(Long stockId, int delta) {
        Stock s = stockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("Stock not found: " + stockId));
        int newQty = (s.getQuantity() == null ? 0 : s.getQuantity()) + delta;
        s.setQuantity(newQty);
        return stockRepository.save(s);
    }
}
