package com.inventory.Inventory.service;
import com.inventory.Inventory.model.Inventory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface InventoryService {
    Inventory saveInventory(Inventory inventory);
    public List<Inventory> getAllInventory();
    Inventory getInventoryById(Long id_inventory);
    Inventory updateInventory(Inventory newInventory, Long id_inventory);
    String deleteInventory(Long id_inventory);
}
