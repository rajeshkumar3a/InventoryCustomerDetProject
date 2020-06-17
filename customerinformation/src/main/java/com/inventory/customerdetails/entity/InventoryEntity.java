package com.inventory.customerdetails.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class InventoryEntity {
	@Id
	@Column(name = "inventory_id")
	private int  inventoryId;
	@Column(name = "store_id")
	private String storeId;
	@Column(name = "last_date")
	private Date lastUpdtDate;
	
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public Date getLastUpdtDate() {
		return lastUpdtDate;
	}
	public void setLastUpdtDate(Date lastUpdtDate) {
		this.lastUpdtDate = lastUpdtDate;
	}	
	
	
	
	
}
