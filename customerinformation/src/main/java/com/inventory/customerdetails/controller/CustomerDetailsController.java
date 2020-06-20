package com.inventory.customerdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.customerdetails.entity.CustomerDetailsEntity;
import com.inventory.customerdetails.reqresp.CustomerDetailRequest;
import com.inventory.customerdetails.service.CustomerDetailsService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/InvCustDetails")
public class CustomerDetailsController {
	
	@Autowired
	CustomerDetailsService customerDetailsService;
		
	
	@GetMapping("/CustDetails")
	public java.util.List<CustomerDetailsEntity> getCustomerDetails()
	{
		return customerDetailsService.getCustomerDetails();
	}
	@PostMapping("/AddCustDetails")
	public ResponseEntity addCustomerDetails(@RequestBody CustomerDetailRequest request)
	{
		
		return customerDetailsService.addCustomerDetails(request);
		
	}
	
	@PostMapping("/DeleteCustDetails/{customerId}")
	public ResponseEntity delCustomerDetails(@PathVariable int customerId )
	{
		
		return customerDetailsService.delCustomerDetails(customerId);
		
	}
	
	@PostMapping("/UpdtCustDetails")
	public ResponseEntity updateCustomerDetails(@RequestBody CustomerDetailRequest request)
	{
		
		return customerDetailsService.updateCustomerDetails(request);
		
	}
}
