package com.inventory.customerdetails.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.inventory.customerdetails.entity.InventoryEntity;
import com.inventory.customerdetails.reqresp.InventoryRequest;

public interface InventoryService {
	
	public List<InventoryEntity> getInvCustomerDetails();
	public ResponseEntity addInvCustomerDetails(InventoryRequest request);
	public ResponseEntity delInvCustomerDetails( int inventoryId);
	public ResponseEntity updateInvCustomerDetails( InventoryRequest request);

}
