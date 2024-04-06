package com.example.shoppingapp.controllers;

import com.example.shoppingapp.models.Inventory;
import com.example.shoppingapp.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.constraints.Min;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory")
    public List<Inventory> getInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/inventory/available")
    public List<Inventory> getAvailableInventory(@RequestParam @Min(1) int quantity) {
        return inventoryService.getAvailableInventoryItems(quantity);
    }
}
