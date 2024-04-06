package com.example.shoppingapp.repositories;

import com.example.shoppingapp.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findByQuantityGreaterThanEqual(int quantity);
}
