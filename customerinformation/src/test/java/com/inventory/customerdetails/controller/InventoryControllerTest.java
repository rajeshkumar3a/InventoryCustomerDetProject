package com.inventory.customerdetails.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.inventory.customerdetails.entity.InventoryEntity;
import com.inventory.customerdetails.reqresp.CustomerDetailRequest;
import com.inventory.customerdetails.reqresp.InventoryRequest;
import com.inventory.customerdetails.service.CustomerDetailsService;
import com.inventory.customerdetails.service.InventoryService;

@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InventoryController.class)
public class InventoryControllerTest {
	 MockMvc mockMvc;

		@MockBean
		private InventoryService inventoryService;
		
		@Autowired
		private InventoryController inventoryController;
		
		@Before
	    public void setup() throws Exception {
	      mockMvc = MockMvcBuilders.standaloneSetup(inventoryController).build();
	      MockitoAnnotations.initMocks(CustomerDetailsService.class);
	    }
		
		@Test
		public void getInventoryDetails() throws Exception {
			
			 List<InventoryEntity> invDetails = getInventoryDetailsList();
		      when(inventoryService.getInvCustomerDetails()).thenReturn(invDetails);
		      mockMvc.perform(get("/InvDetails/InvCustDetails")
		    		  .contentType(MediaType.APPLICATION_JSON))
		      .andExpect(status().isOk());
		      invDetails = inventoryController.getInvCustomerDetails();
		      assertNotNull(invDetails);
		     
		}
		
		@Test
		public void addInvCustomerDetails() throws Exception {

			ResponseEntity invDetails = getcustomerDetailsResponse();
			InventoryRequest request=new InventoryRequest();
			 request.setInventoryId(1);
			      MockHttpServletRequest request1 = new MockHttpServletRequest();
		        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request1));
		       
		        when(inventoryService.addInvCustomerDetails(Mockito.any())).thenReturn(invDetails);
		        
		        invDetails = inventoryController.addInvCustomerDetails(request);
		        assertThat(invDetails.getStatusCodeValue()).isEqualTo(201);
		    
			
		}
		
		@Test
		public void delInvDetails() throws Exception {

			ResponseEntity invDetails = delcustomerDetailsResponse();
			 CustomerDetailRequest request=new CustomerDetailRequest();
			 request.setCustomerId(1);
			      MockHttpServletRequest request1 = new MockHttpServletRequest();
		        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request1));
		       
		        when(inventoryService.delInvCustomerDetails(Mockito.anyInt())).thenReturn(invDetails);
		        int id =1;
		        invDetails = inventoryController.delInvCustomerDetails(id);
		        assertThat(invDetails.getStatusCodeValue()).isEqualTo(200);
		    
			
		}
		@Test
		public void updtInvCustomerDetails() throws Exception {

			ResponseEntity invDetails = getcustomerDetailsResponse();
			InventoryRequest request=new InventoryRequest();
			 request.setInventoryId(1);
			      MockHttpServletRequest request1 = new MockHttpServletRequest();
		        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request1));
		       
		        when(inventoryService.updateInvCustomerDetails(Mockito.any())).thenReturn(invDetails);
		        
		        invDetails = inventoryController.updateInvCustomerDetails(request);
		        assertThat(invDetails.getStatusCodeValue()).isEqualTo(201);
		    
			
		}
		
		 private List<InventoryEntity> getInventoryDetailsList() {
		      List<InventoryEntity> custDetailList = new ArrayList<>();
		      InventoryEntity invDetails = new InventoryEntity();
		      invDetails.setInventoryId(1);
		      invDetails.setStoreId("1");
		     
		      custDetailList.add(invDetails);
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
