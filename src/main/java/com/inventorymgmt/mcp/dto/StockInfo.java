
package com.inventorymgmt.mcp.dto;

import lombok.Data;
import com.inventorymgmt.mcp.models.enums.Location;

@Data
public class StockInfo {
    private String materialType;
    private String materialName;
    private Integer quantity;
    private Location location;

    public StockInfo() {}

    public StockInfo(String materialType, Integer quantity, Location location, String materialName) {
        this.materialType = materialType;
        this.quantity = quantity;
        this.location = location;
        this.materialName = materialName;
    }
}