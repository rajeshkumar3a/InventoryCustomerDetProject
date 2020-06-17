package com.inventory.customerdetails.reqresp;

import java.util.Date;

public class InventoryRequest {
	private int inventoryId;

	private String storeId;
	private Date lstUpdtDate;

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
	public Date getLstUpdtDate() {
		return lstUpdtDate;
	}
	public void setLstUpdtDate(Date lstUpdtDate) {
		this.lstUpdtDate = lstUpdtDate;
	}
	
	
	
	
	
}
