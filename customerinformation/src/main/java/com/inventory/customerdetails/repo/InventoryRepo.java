package com.inventory.customerdetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.customerdetails.entity.InventoryEntity;


@Repository
public interface InventoryRepo extends JpaRepository<InventoryEntity,Integer>{

}
