package com.inventory.customerdetails.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.inventory.customerdetails.entity.CustomerDetailsEntity;
import com.inventory.customerdetails.reqresp.CustomerDetailRequest;
import com.inventory.customerdetails.service.CustomerDetailsService;
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CustomerDetailsController.class)


public class CustomerDetailsControllerTest {

	 MockMvc mockMvc;

	@MockBean
	private CustomerDetailsService customerDetailsService;
	
	@Autowired
	private CustomerDetailsController customerDetailsController;
	
	@Before
    public void setup() throws Exception {
      mockMvc = MockMvcBuilders.standaloneSetup(customerDetailsController).build();
      MockitoAnnotations.initMocks(CustomerDetailsService.class);
    }
	
	@Test
	public void getCustomerDetails() throws Exception {
		
		 List<CustomerDetailsEntity> custDetailList = getCustomerDetailsList();
	      when(customerDetailsService.getCustomerDetails()).thenReturn(custDetailList);
	      mockMvc.perform(get("/InvCustDetails/CustDetails")
	    		  .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	      custDetailList = customerDetailsController.getCustomerDetails();
	      assertNotNull(custDetailList);
	     
	}
	@Test
	public void getCustomerDetailsException() throws Exception {
		
		 List<CustomerDetailsEntity> custDetailList = getCustomerDetailsList();
	      when(customerDetailsService.getCustomerDetails()).thenReturn(custDetailList);
	      mockMvc.perform(get("/InvCustDetails/CustDeta")
	    		  .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().is4xxClientError());
	      custDetailList = customerDetailsController.getCustomerDetails();
	      assertNotNull(custDetailList);
	     
	}
	
	
	@Test
	public void addCustomerDetails() throws Exception {

		ResponseEntity custDetails = getcustomerDetailsResponse();
		 CustomerDetailRequest request=new CustomerDetailRequest();
		 request.setCustomerId(1);
		      MockHttpServletRequest request1 = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request1));
	       
	        when(customerDetailsService.addCustomerDetails(Mockito.any())).thenReturn(custDetails);
	        
	        custDetails = customerDetailsController.addCustomerDetails(request);
	        assertThat(custDetails.getStatusCodeValue()).isEqualTo(201);
	    
		
	}
	
	@Test
	public void delCustomerDetails() throws Exception {

		ResponseEntity custDetails = delcustomerDetailsResponse();
		 CustomerDetailRequest request=new CustomerDetailRequest();
		 request.setCustomerId(1);
		      MockHttpServletRequest request1 = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request1));
	       
	        when(customerDetailsService.delCustomerDetails(Mockito.anyInt())).thenReturn(custDetails);
	        int id =1;
	        custDetails = customerDetailsController.delCustomerDetails(id);
	        assertThat(custDetails.getStatusCodeValue()).isEqualTo(200);
	    
		
	}
	
	
	@Test
	public void updateCustomerDetails() throws Exception {

		ResponseEntity custDetails = getcustomerDetailsResponse();
		 CustomerDetailRequest request=new CustomerDetailRequest();
		 request.setCustomerId(1);
		      MockHttpServletRequest request1 = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request1));
	       
	        when(customerDetailsService.updateCustomerDetails(Mockito.any())).thenReturn(custDetails);
	        
	        custDetails = customerDetailsController.updateCustomerDetails(request);
	        assertThat(custDetails.getStatusCodeValue()).isEqualTo(201);
	    
		
	}
	
	 private List<CustomerDetailsEntity> getCustomerDetailsList() {
	      List<CustomerDetailsEntity> custDetailList = new ArrayList<>();
	      CustomerDetailsEntity custDetails = new CustomerDetailsEntity();
	      custDetails.setCustomerId(1);
	      custDetails.setStoreId("1");
	      custDetails.setFirstName("Raj");
	      custDetailList.add(custDetails);
	      return custDetailList;
	     
	   }
	 
	 private ResponseEntity getcustomerDetailsResponse() {
	   
	      ResponseEntity entity=new ResponseEntity("Successfully Completed",HttpStatus.CREATED);
	      return entity;
	     
	   }
	 private ResponseEntity delcustomerDetailsResponse() {
		   
	      ResponseEntity entity=new ResponseEntity("Successfully Completed",HttpStatus.OK);
	      return entity;
	     
	   }

}


