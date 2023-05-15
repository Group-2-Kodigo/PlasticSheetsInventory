package com.inventory.Inventory.controller;
import com.inventory.Inventory.model.Colors;
import com.inventory.Inventory.model.Inventory;
import com.inventory.Inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public String add(@RequestBody Inventory inventory){
        inventoryService.saveInventory(inventory);
        return "New inventory Added";
    }
    @GetMapping("/getAll")
    public List<Inventory> getAllInventory(){
        return inventoryService.getAllInventory();
    }
    @GetMapping("/getInventoryByID/{id_inventory}")
    public Inventory getInventoryById(@PathVariable Long id_inventory) {
        return inventoryService.getInventoryById(id_inventory);
    }
    @PutMapping("/updateInventory/{id_inventory}")
    public Inventory updateInventory(@RequestBody Inventory newInventory, @PathVariable Long id_inventory){
        return inventoryService.updateInventory(newInventory, id_inventory);
    }
    @DeleteMapping("/deleteInventory/{id_inventory}")
    public String deleteInventory (@PathVariable Long id_inventory){
        return inventoryService.deleteInventory(id_inventory);
    }


}
