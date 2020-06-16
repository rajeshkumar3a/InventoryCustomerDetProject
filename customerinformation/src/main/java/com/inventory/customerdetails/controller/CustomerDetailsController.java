package com.inventory.customerdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.customerdetails.entity.CustomerDetailsEntity;
import com.inventory.customerdetails.reqresp.CustomerDetailRequest;
import com.inventory.customerdetails.reqresp.CustomerDetailResponse;
import com.inventory.customerdetails.service.CustomerDetailsService;

@RestController
public class CustomerDetailsController {
	
	@Autowired
	CustomerDetailsService customerDetailsService;
	
		
	
	@RequestMapping("CustDetails")
	public java.util.List<CustomerDetailsEntity> getCustomerDetails()
	{
		return customerDetailsService.getCustomerDetails();
	}
	@RequestMapping("AddCustDetails")
	public ResponseEntity addCustomerDetails(@RequestBody CustomerDetailRequest request)
	{
		
		return customerDetailsService.addCustomerDetails(request);
		
	}
	
	@RequestMapping("DeleteCustDetails/{customerId}")
	public ResponseEntity delCustomerDetails(@PathVariable int customerId )
	{
		
		return customerDetailsService.delCustomerDetails(customerId);
		
	}
	
	@RequestMapping("UpdtCustDetails")
	public ResponseEntity updateCustomerDetails(@RequestBody CustomerDetailRequest request)
	{
		
		return customerDetailsService.updateCustomerDetails(request);
		
	}
}
