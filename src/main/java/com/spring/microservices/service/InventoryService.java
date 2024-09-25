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

    public Inventory retrieveInventory(Long id){
        return retrieveInventorybyProductId(id);
    }

    public Inventory updateInventory(Inventory inventory, Long id){
        Inventory availableInventory = retrieveInventorybyProductId(id);
        availableInventory.setQuantity(null!=inventory.getQuantity()?availableInventory.getQuantity()-inventory.getQuantity(): availableInventory.getQuantity());
        return inventoryRepository.save(availableInventory);
    }

    private Inventory retrieveInventorybyProductId(Long id) {
        return inventoryRepository.findByProductId(id);
    }

}
