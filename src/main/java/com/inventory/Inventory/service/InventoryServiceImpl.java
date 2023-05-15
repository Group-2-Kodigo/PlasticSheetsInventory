package com.inventory.Inventory.service;
import com.inventory.Inventory.exception.DetailNotFoundException;
import com.inventory.Inventory.model.Inventory;
import com.inventory.Inventory.model.InvoiceDetail;
import org.springframework.stereotype.Service;
import com.inventory.Inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public Inventory saveInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }
    @Override
    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }
    @Override
    public Inventory getInventoryById(Long id_inventory) {
        return inventoryRepository.findById(id_inventory).orElseThrow(()->new DetailNotFoundException(id_inventory));
    }
    @Override
    public Inventory updateInventory(Inventory newInventory, Long id_inventory) {
        return inventoryRepository.findById(id_inventory).map(inventory -> {
            inventory.setQuantity(newInventory.getQuantity());
            inventory.setMovementDate(newInventory.getMovementDate());
            inventory.setMovementHour(newInventory.getMovementHour());
            inventory.setMovement(newInventory.getMovement());
            inventory.setUser(newInventory.getUser());
            inventory.setProduct(newInventory.getProduct());
            inventory.setInvoiceHeader(newInventory.getInvoiceHeader());
            return inventoryRepository.save(inventory);
        }).orElseThrow(() -> new DetailNotFoundException(id_inventory));
    }
    @Override
    public String deleteInventory(Long id_inventory) {
        if (!inventoryRepository.existsById(id_inventory)){
            throw new DetailNotFoundException(id_inventory);
        }
        inventoryRepository.deleteById(id_inventory);
        return "Inventory with id " + id_inventory + " has been deleted success";
    }


}
