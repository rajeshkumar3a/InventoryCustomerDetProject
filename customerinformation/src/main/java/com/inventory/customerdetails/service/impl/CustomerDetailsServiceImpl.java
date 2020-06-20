package com.inventory.customerdetails.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.customerdetails.CustomerdetailsApplication;
import com.inventory.customerdetails.entity.CustomerDetailsEntity;
import com.inventory.customerdetails.repo.CustomerDetailsRepo;
import com.inventory.customerdetails.reqresp.CustomerDetailRequest;
import com.inventory.customerdetails.reqresp.CustomerDetailResponse;
import com.inventory.customerdetails.service.CustomerDetailsService;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService{

	@Autowired
	CustomerDetailsRepo customerDetailsRepo;
	
	
	 private static Logger logger = (Logger) LogManager.getLogger(CustomerDetailsServiceImpl.class);

	@Override
	public List<CustomerDetailsEntity> getCustomerDetails() {
		logger.info("Start service getCustomerDetails");
		
		return customerDetailsRepo.findAll();
	}
	@Override
	public ResponseEntity addCustomerDetails(CustomerDetailRequest request) {
		try {
			logger.info("Start Service addCustomerDetails");
		CustomerDetailsEntity entity=new CustomerDetailsEntity();
		CustomerDetailResponse response=new CustomerDetailResponse();
		
		entity.setCustomerId(request.getCustomerId());
		entity.setStoreId(request.getStoreId());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setAddressId(request.getAddressId());
		entity.setEmail(request.getEmail());
		entity.setCreateDate(request.getCreateDate());
		entity.setLastUpdate(request.getLastUpdate());
		entity.setActive(request.getActive());
		
		
		customerDetailsRepo.save(entity);
		response.setStatus("Sucessfully added");
		logger.info("End Service addCustomerDetails");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Excaption",e);
		}
		return new  ResponseEntity("Customer Details added successfully", HttpStatus.OK);
	}
	@Override
	public ResponseEntity delCustomerDetails(int customerId) {
		try {
		logger.info("Start Service delCustomerDetails");
		CustomerDetailResponse response=new CustomerDetailResponse();
		
		//customerDetailsRepo.deleteCustomerById(request.getCustomerId());
		customerDetailsRepo.deleteById(customerId);
		response.setStatus("Sucessfully Deleted");
		logger.info("End Service delCustomerDetails");
		}
		catch(Exception e)
		{
			logger.info("Excaption",e);
		}
		return new  ResponseEntity("Customer Details deleted successfully", HttpStatus.OK);
	}
	@Override
	public ResponseEntity updateCustomerDetails(CustomerDetailRequest request) {

		try {
			
			logger.info("Start Service updateCustomerDetails");
		CustomerDetailsEntity entity=new CustomerDetailsEntity();
		CustomerDetailResponse response=new CustomerDetailResponse();
		
		entity.setCustomerId(request.getCustomerId());
		entity.setStoreId(request.getStoreId());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setAddressId(request.getAddressId());
		entity.setEmail(request.getEmail());
		entity.setCreateDate(request.getCreateDate());
		entity.setLastUpdate(request.getLastUpdate());
		entity.setActive(request.getActive());
		
		
		customerDetailsRepo.save(entity);
		response.setStatus("Sucessfully Updated");
		logger.info("End Service updateCustomerDetails");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Excaption",e);
		}
		return new  ResponseEntity("Customer Details updated successfully", HttpStatus.OK);
	
	}

}
