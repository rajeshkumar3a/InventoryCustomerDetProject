package com.inventory.customerdetails.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.customerdetails.entity.InventoryEntity;
import com.inventory.customerdetails.repo.InventoryRepo;
import com.inventory.customerdetails.reqresp.InventoryRequest;
import com.inventory.customerdetails.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	InventoryRepo inventoryRepo;

	@Override
	public List<InventoryEntity> getInvCustomerDetails() {
		// TODO Auto-generated method stub
		return inventoryRepo.findAll();
	}

	@Override
	public ResponseEntity addInvCustomerDetails(InventoryRequest request) {
		InventoryEntity entity=new InventoryEntity();
		entity.setInventoryId(request.getInventoryId());
		entity.setStoreId(request.getStoreId());
		entity.setLastUpdtDate(request.getLstUpdtDate());
		inventoryRepo.save(entity);
		
		return new  ResponseEntity("Inventory Details added successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity delInvCustomerDetails(int inventoryId) {
		inventoryRepo.deleteById(inventoryId);
		
		return new  ResponseEntity("Inventory Details deleted successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateInvCustomerDetails(InventoryRequest request) {
		InventoryEntity entity=new InventoryEntity();
		entity.setInventoryId(request.getInventoryId());
		entity.setStoreId(request.getStoreId());
		entity.setLastUpdtDate(request.getLstUpdtDate());
		inventoryRepo.save(entity);
		
		return new  ResponseEntity("Inventory Details updated successfully", HttpStatus.OK);
	}

}
