package com.inventory.customerdetails.repo;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.customerdetails.entity.CustomerDetailsEntity;

@Repository
public interface CustomerDetailsRepo extends JpaRepository<CustomerDetailsEntity,Integer> {
	/*
	 * @Modifying
	 * 
	 * @Query("delete from CustomerDetailsEntity u where u.customerId = :customerId"
	 * ) void deleteCustomerById(@Param("customerId") int customerId);
	 */
}
