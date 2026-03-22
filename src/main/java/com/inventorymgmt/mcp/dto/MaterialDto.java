package com.inventorymgmt.mcp.dto;

import com.inventorymgmt.mcp.models.enums.MaterialType;
import lombok.Data;

@Data
public class MaterialDto {
    private String name;
    private MaterialType type;
    private String unit;
    public MaterialDto() {}
    public MaterialDto(String name, MaterialType type, String unit) {
        this.name = name;
        this.type = type;
        this.unit = unit;
    }
}