package com.inventorymgmt.mcp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.inventorymgmt.mcp.models.enums.MaterialType;
import lombok.Data;

@Entity
@Table(name = "material")
@Data
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaterialType type;

    private String unit;

    public Material() {}
    public Material(Long id, String name, MaterialType type, String unit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.unit = unit;
    }
}
