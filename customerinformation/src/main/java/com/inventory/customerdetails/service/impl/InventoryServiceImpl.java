package com.inventory.customerdetails.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.customerdetails.CustomerdetailsApplication;
import com.inventory.customerdetails.entity.InventoryEntity;
import com.inventory.customerdetails.repo.InventoryRepo;
import com.inventory.customerdetails.reqresp.InventoryRequest;
import com.inventory.customerdetails.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	InventoryRepo inventoryRepo;
	
	private static Logger logger = (Logger) LogManager.getLogger(InventoryServiceImpl.class);


	@Override
	public List<InventoryEntity> getInvCustomerDetails() {
		// TODO Auto-generated method stub
		logger.info("Start service getInvCustomerDetails");
		return inventoryRepo.findAll();
	}

	@Override
	public ResponseEntity addInvCustomerDetails(InventoryRequest request) {
		try {
			logger.info("Start Service addInvCustomerDetails");
		InventoryEntity entity=new InventoryEntity();
		entity.setInventoryId(request.getInventoryId());
		entity.setStoreId(request.getStoreId());
		entity.setLastUpdtDate(request.getLstUpdtDate());
		inventoryRepo.save(entity);
		logger.info("End Service addInvCustomerDetails");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Excaption",e);
		}
		return new  ResponseEntity("Inventory Details added successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity delInvCustomerDetails(int inventoryId) {
		try{
			logger.info("Start Service delInvCustomerDetails");
		inventoryRepo.deleteById(inventoryId);
		logger.info("End Service delInvCustomerDetails");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Excaption",e);
		}
		return new  ResponseEntity("Inventory Details deleted successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateInvCustomerDetails(InventoryRequest request) {
		try {
			logger.info("Start Service updateInvCustomerDetails");
		InventoryEntity entity=new InventoryEntity();
		entity.setInventoryId(request.getInventoryId());
		entity.setStoreId(request.getStoreId());
		entity.setLastUpdtDate(request.getLstUpdtDate());
		inventoryRepo.save(entity);
		logger.info("Start Service updateInvCustomerDetails");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Excaption",e);
		}
		return new  ResponseEntity("Inventory Details updated successfully", HttpStatus.OK);
	}

}
