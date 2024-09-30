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
    public ResponseEntity<List<Inventory>> retrieveInventory(@PathVariable Long id){
        return ResponseEntity.ok(inventoryService.retrieveInventory(id));
    }

    @GetMapping("/inventory/{id}/{zipCode}")
    public ResponseEntity<List<Inventory>> retrieveInventoryByZipCode(@PathVariable Long id, @PathVariable Integer zipCode){
        return ResponseEntity.ok(inventoryService.retrieveInventory(id, zipCode));
    }

    @PostMapping("/inventory/{id}/{zipCode}")
    public void updateInventory(@RequestBody Inventory inventory, @PathVariable Long id, @PathVariable Integer zipCode){

        inventoryService.updateInventory(inventory, id, zipCode);

    }


}
