package com.example.shoppingapp.services;

import com.example.shoppingapp.models.Inventory;
import com.example.shoppingapp.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public List<Inventory> getAvailableInventoryItems(int quantity) {
        return inventoryRepository.findByQuantityGreaterThanEqual(quantity);
    }
}
