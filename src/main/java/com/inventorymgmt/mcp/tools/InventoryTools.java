package com.inventorymgmt.mcp.tools;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import com.inventorymgmt.mcp.dto.StockInfo;
import com.inventorymgmt.mcp.dto.MaterialDto;
import com.inventorymgmt.mcp.services.InventoryService;
import com.inventorymgmt.mcp.models.enums.MaterialType;
import com.inventorymgmt.mcp.models.Stock;
import com.inventorymgmt.mcp.models.enums.Location;

import java.util.List;

@Service 
public class InventoryTools {

    private final InventoryService inventoryService;

    public InventoryTools(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
   
   @McpTool(name = "getStockByMaterialType",
            description = "Fetches the stock quantity, location, name and type for all the available material for a given Material Type provided as input. Example: getStockByMaterialType('CONSTRUCTION')")
   public List<StockInfo>  getTotalStockByMaterialType(
        @McpToolParam(description = "Type of material (e.g., CONSTRUCTION, ELECTRICAL, etc.)") String materialType
    ) {
        String sanitizedType = materialType == null ? null : materialType.trim().replaceAll("\\s+", " ").toUpperCase();
        MaterialType typeEnum = null;
        try {
            typeEnum = MaterialType.valueOf(sanitizedType);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid material type: " + materialType);
        }
        List<Stock> stocks = inventoryService.getStocksByMaterialType(typeEnum);
        List<StockInfo> response = stocks.stream()
                                .map(s -> new StockInfo(
                                    s.getMaterial().getType().name(),
                                    s.getQuantity() == null ? 0 : s.getQuantity(),
                                    s.getLocation(),
                                    s.getMaterial().getName()))
                                .toList();
        return response;
    }

    @McpTool(name = "getMaterialInfoByMaterialType",
            description = "Lists the detailed information of materials against the material type")
    public List<MaterialDto> getMaterialInfoByMaterialType(
        @McpToolParam(description = "Type of material (e.g., CONSTRUCTION, ELECTRICAL, etc.)") String materialType
    ) {
        String sanitizedType = materialType == null ? null : materialType.trim().replaceAll("\\s+", " ").toUpperCase();
        MaterialType typeEnum = null;
        try {
            typeEnum = MaterialType.valueOf(sanitizedType);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid material type: " + materialType);
        }
        List<MaterialDto> materials = inventoryService.getMaterialsByType(typeEnum)
                .stream()
                .map(m -> new MaterialDto(m.getName(), m.getType(), m.getUnit()))
                .toList();
        return materials;
    }

    @McpTool(name = "getStockByLocation",
            description = "Fetches the stock quantity, location, name and type for all the available material for a given location provided as input. Example: getStockByLocation('Warehouse A')")
    public List<StockInfo>  getStockByLocation(
        @McpToolParam(description = "Location (e.g., Warehouse A, Warehouse B, Office Store etc.)") String location
    ) {
        String sanitizedLoc = location == null ? null : location.trim().replaceAll("\\s+", " ");
        Location locEnum = Location.fromString(sanitizedLoc);
        System.out.println("Parsed location: " + locEnum);
        if (locEnum == null) {
            throw new IllegalArgumentException("Invalid location: " + location);
        }
        List<Stock> stocks = inventoryService.getStocksByLocation(locEnum);
        
        List<StockInfo> response = stocks.stream()
                                .map(s -> new StockInfo(
                                    s.getMaterial().getType().name(),
                                    s.getQuantity() == null ? 0 : s.getQuantity(),
                                    s.getLocation(),
                                    s.getMaterial().getName()))
                                .toList();
        return response;
    }
    
}