package com.inventorymgmt.mcp.repositories;

import com.inventorymgmt.mcp.models.Stock;
import com.inventorymgmt.mcp.models.enums.MaterialType;
import java.util.List;
import com.inventorymgmt.mcp.models.enums.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByMaterialType(MaterialType type);
    List<Stock> findByMaterialId(Long materialId);
    List<Stock> findByLocation(Location location);
}
