package com.inventory.customerdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.customerdetails.entity.InventoryEntity;
import com.inventory.customerdetails.reqresp.InventoryRequest;
import com.inventory.customerdetails.service.InventoryService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/InvDetails")
public class InventoryController {
	
	
	
	@Autowired
	InventoryService inventoryService;
	@GetMapping("/InvCustDetails")
	public List<InventoryEntity> getInvCustomerDetails()
	{
		return inventoryService.getInvCustomerDetails();
		
	}
	
	
	@PostMapping("/AddInvCustDetails")
	public ResponseEntity addInvCustomerDetails(@RequestBody InventoryRequest request)
	{
		
		return inventoryService.addInvCustomerDetails(request);
		
	}
	
	@PostMapping("/DeleteInvCustDetails/{inventoryId}")
	public ResponseEntity delInvCustomerDetails(@PathVariable int inventoryId )
	{
		
		return inventoryService.delInvCustomerDetails(inventoryId);
		
	}
	
	@PostMapping("/UpdtInvCustDetails")
	public ResponseEntity updateInvCustomerDetails(@RequestBody InventoryRequest request)
	{
		
		return inventoryService.updateInvCustomerDetails(request);
		
	}

}
