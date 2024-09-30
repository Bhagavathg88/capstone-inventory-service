package com.spring.microservices.repository;

import com.spring.microservices.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

    List<Inventory> findByProductId(Long id);

    List<Inventory> findByProductIdAndZipcode(Long id, Integer zipcode);
}
