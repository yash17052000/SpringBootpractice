package com.Inventory.InventoryService.Service;

import com.Inventory.InventoryService.Repository.InventoryRepository;
import com.Inventory.InventoryService.model.Inventory;

import java.util.Optional;

public class InventoryService {

    private  final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }


    public Inventory checkStock(Long productId) {
        Optional<Inventory> inv = inventoryRepository.findById(productId);
        return inv.get();
    }
}
