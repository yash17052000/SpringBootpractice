package com.Inventory.InventoryService.Repository;

import com.Inventory.InventoryService.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
