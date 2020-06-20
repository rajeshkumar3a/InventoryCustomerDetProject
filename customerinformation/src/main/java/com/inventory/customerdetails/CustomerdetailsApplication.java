package com.inventory.customerdetails;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class CustomerdetailsApplication {
	   private static Logger LOGGER = (Logger) LogManager.getLogger(CustomerdetailsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CustomerdetailsApplication.class, args);
	}

}
