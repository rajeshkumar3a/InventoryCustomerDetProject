package com.inventory.customerdetails.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.inventory.customerdetails.entity.CustomerDetailsEntity;
import com.inventory.customerdetails.reqresp.CustomerDetailRequest;
import com.inventory.customerdetails.reqresp.CustomerDetailResponse;

public interface CustomerDetailsService {
	public List<CustomerDetailsEntity> getCustomerDetails();
	public ResponseEntity addCustomerDetails(CustomerDetailRequest request);
	public ResponseEntity delCustomerDetails( int customerId);
	public ResponseEntity updateCustomerDetails( CustomerDetailRequest request);
}
