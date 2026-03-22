package com.inventorymgmt.mcp.repositories;

import com.inventorymgmt.mcp.models.Material;
import com.inventorymgmt.mcp.models.enums.MaterialType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByType(MaterialType type);
}
