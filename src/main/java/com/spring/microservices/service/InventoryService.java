package com.spring.microservices.service;

import com.spring.microservices.model.Inventory;
import com.spring.microservices.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;


    public List<Inventory> createInventories(List<Inventory> inventories){
        return inventoryRepository.saveAll(inventories);
    }

    public List<Inventory> retrieveInventories(){
        return inventoryRepository.findAll();
    }

    public List<Inventory> retrieveInventory(Long id){
        return retrieveInventorybyProductId(id);
    }

    public List<Inventory> retrieveInventory(Long id, Integer zipCode){
        return inventoryRepository.findByProductIdAndZipcode(id, zipCode);
    }

    public Inventory retrieveInventor(Long id){
        return inventoryRepository.findById(id).get();
    }

    private List<Inventory> retrieveInventorybyProductId(Long id) {
        return inventoryRepository.findByProductId(id);
    }

    public void updateInventory(Inventory inventory, Long id, Integer zipCode) {


        List<Inventory> inventories = inventoryRepository.findByProductIdAndZipcode(id, zipCode);
        for(Inventory inv : inventories){
            inv.setQuantity(inv.getQuantity()-inventory.getQuantity());
            inventoryRepository.save(inv);
        }

    }
}
