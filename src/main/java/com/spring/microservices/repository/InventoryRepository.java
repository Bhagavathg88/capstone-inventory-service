package com.spring.microservices.repository;

import com.spring.microservices.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

    Inventory findByProductId(Long id);
}
