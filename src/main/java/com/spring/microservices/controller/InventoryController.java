package com.spring.microservices.controller;

import com.spring.microservices.model.Inventory;
import com.spring.microservices.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/inventories")
    public ResponseEntity<List<Inventory>> createInventories(@RequestBody List<Inventory> inventories){
        return ResponseEntity.ok(inventoryService.createInventories(inventories));
    }

    @GetMapping("/inventories")
    public ResponseEntity<List<Inventory>> retrieveInventories(){
        return ResponseEntity.ok(inventoryService.retrieveInventories());
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<Inventory> retrieveInventory(@PathVariable Long id){
        return ResponseEntity.ok(inventoryService.retrieveInventory(id));
    }

    @PostMapping("/inventory/{id}")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory, @PathVariable Long id){
        return ResponseEntity.ok(inventoryService.updateInventory(inventory, id));
    }
}
